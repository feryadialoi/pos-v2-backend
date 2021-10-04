package com.gdi.posbackend.command.impl.sale;

import com.gdi.posbackend.command.sale.CreateSaleCommand;
import com.gdi.posbackend.entity.Sale;
import com.gdi.posbackend.entity.SaleDetail;
import com.gdi.posbackend.entity.SaleOrder;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.RunningNumberPrefix;
import com.gdi.posbackend.entity.enums.SaleOrderStatus;
import com.gdi.posbackend.exception.CreateSaleNotAllowedException;
import com.gdi.posbackend.exception.SaleOrderAlreadyCreateToSaleException;
import com.gdi.posbackend.mapper.SaleMapper;
import com.gdi.posbackend.model.SaleCalculatedResult;
import com.gdi.posbackend.model.commandparam.CreateSaleCommandParam;
import com.gdi.posbackend.model.request.CreateSaleRequest;
import com.gdi.posbackend.model.request.ProductOfCreateSaleRequest;
import com.gdi.posbackend.model.response.DetailedSaleResponse;
import com.gdi.posbackend.repository.SaleRepository;
import com.gdi.posbackend.service.*;
import com.gdi.posbackend.util.DiscountUtil;
import com.gdi.posbackend.util.RunningNumberCodeUtil;
import com.gdi.posbackend.util.TaxUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:36 AM
 */
@Component
@Transactional
@AllArgsConstructor
public class CreateSaleCommandImpl implements CreateSaleCommand {

    // ** repository
    private final SaleRepository saleRepository;

    // ** mapper
    private final SaleMapper saleMapper;

    // ** util
    private final RunningNumberCodeUtil runningNumberCodeUtil;
    private final DiscountUtil discountUtil;
    private final TaxUtil taxUtil;

    // ** service
    private final RunningNumberService runningNumberService;
    private final StorageService storageService;
    private final SaleOrderService saleOrderService;
    private final CustomerService customerService;
    private final SalesmanService salesmanService;
    private final JournalService journalService;
    private final ProductStockService productStockService;
    private final ProductService productService;
    private final WarehouseService warehouseService;
    private final UnitService unitService;


    @Override
    public DetailedSaleResponse execute(CreateSaleCommandParam createSaleCommandParam) {
        CreateSaleRequest createSaleRequest = createSaleCommandParam.getCreateSaleRequest();

        checkSaleOrderAlreadyCreateSale(createSaleRequest);

        checkSaleOrderStatusIfPresent(createSaleRequest);

        Sale sale = doCreateSale(createSaleRequest);

        productStockService.updateProductStockBySale(sale);

        // journalService.postJournalOfSale(sale);

        return saleMapper.mapSaleToDetailedSaleResponse(sale);
    }

    private void checkSaleOrderAlreadyCreateSale(CreateSaleRequest createSaleRequest) {
        if (createSaleRequest.getSaleOrderId() != null) {
            SaleOrder saleOrder = saleOrderService.findSaleOrderByIdOrThrowNotFound(createSaleRequest.getSaleOrderId());
            if (saleRepository.existsBySaleOrder(saleOrder)) {
                throw new SaleOrderAlreadyCreateToSaleException("sale order already create to sale");
            }
        }
    }

    private void checkSaleOrderStatusIfPresent(CreateSaleRequest createSaleRequest) {
        if (createSaleRequest.getSaleOrderId() != null) {
            SaleOrder saleOrder = saleOrderService.findSaleOrderByIdOrThrowNotFound(createSaleRequest.getSaleOrderId());

            if (saleOrder.getStatus() != SaleOrderStatus.ACCEPTED) {
                throw new CreateSaleNotAllowedException("not allowed to create sale from sale order with status " + saleOrder.getStatus());
            }

        }
    }

    @SuppressWarnings("Duplicates")
    private Sale doCreateSale(CreateSaleRequest createSaleRequest) {
        Sale sale = new Sale();
        sale.setCode(runningNumberCodeUtil.getFormattedCode(runningNumberService.getRunningNumber(RunningNumberPrefix.S)));
        sale.setSaleOrder(getSaleOrder(createSaleRequest));
        sale.setReference(createSaleRequest.getReference());
        sale.setCustomer(customerService.findCustomerByIdOrThrowNotFound(createSaleRequest.getCustomerId()));
        sale.setSalesman(salesmanService.findSalesmanByIdOrThrowNotFound(createSaleRequest.getSalesmanId()));

        sale.setPaymentType(createSaleRequest.getPaymentType());
        sale.setEntryDate(createSaleRequest.getEntryDate());

        if (createSaleRequest.getPaymentType() == PaymentType.CREDIT) {
            sale.setDueDate(createSaleRequest.getDueDate());
            sale.setTerm(createSaleRequest.getTerm());
        }

        sale.setStatus(createSaleRequest.getStatus());

        SaleCalculatedResult saleCalculatedResult = calculateSale(createSaleRequest, sale);
        sale.setIsTaxed(taxUtil.getIsTaxed(saleCalculatedResult.getTotalTax()));
        sale.setTax(saleCalculatedResult.getTotalTax());
        sale.setIsDiscounted(discountUtil.getIsDiscounted(saleCalculatedResult.getTotalDiscount()));
        sale.setDiscount(saleCalculatedResult.getTotalDiscount());
        sale.setTotal(saleCalculatedResult.getTotal());
        sale.setGrandTotal(saleCalculatedResult.getGrandTotal());
        sale.setSaleDetails(saleCalculatedResult.getSaleDetails());

        sale.setNote(createSaleRequest.getNote());
        sale.setAttachment(storageService.uploadImageFile(null));

        sale = saleRepository.save(sale);

        return sale;
    }

    @SuppressWarnings("Duplicates")
    private SaleCalculatedResult calculateSale(CreateSaleRequest createSaleRequest, Sale sale) {
        ArrayList<SaleDetail> saleDetails = new ArrayList<>();
        BigDecimal totalTax = BigDecimal.ZERO;
        BigDecimal totalDiscount = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;

        for (ProductOfCreateSaleRequest product : createSaleRequest.getProducts()) {
            SaleDetail saleDetail = new SaleDetail();
            saleDetail.setSale(sale);
            saleDetail.setProduct(productService.findProductByIdOrThrowNotFound(product.getProductId()));
            saleDetail.setWarehouse(warehouseService.findWarehouseByIdOrThrowNotFound(product.getWarehouseId()));
            saleDetail.setUnit(unitService.findUnitByIdOrThrowNotFound(product.getUnitId()));
            saleDetail.setDiscount(product.getDiscount());
            saleDetail.setDiscountFormat(product.getDiscountFormat());
            saleDetail.setTax(product.getTax());
            saleDetail.setTaxFormat(product.getTaxFormat());
            saleDetail.setPrice(product.getPrice());
            saleDetail.setQuantity(product.getQuantity());
            saleDetail.setTotal(calculateSaleDetailTotal(product));

            saleDetails.add(saleDetail);

            BigDecimal discount = discountUtil.calculateDiscount(product.getPrice(), product.getDiscountFormat(), product.getDiscount());
            BigDecimal priceAfterDiscount = product.getPrice().subtract(discount);
            BigDecimal tax = taxUtil.calculateTax(priceAfterDiscount, product.getTaxFormat(), product.getTax());

            totalDiscount = totalDiscount.add(discount);
            totalTax = totalTax.add(tax);
            total = total.add(product.getPrice().multiply(product.getQuantity()));

        }

        BigDecimal grandTotal = total.subtract(totalDiscount)
                .add(totalTax)
                .add(createSaleRequest.getShippingFee())
                .add(createSaleRequest.getShippingFee());

        return new SaleCalculatedResult(
                saleDetails,
                totalTax,
                totalDiscount,
                total,
                grandTotal
        );
    }

    private BigDecimal calculateSaleDetailTotal(ProductOfCreateSaleRequest product) {
        return product.getPrice().multiply(product.getQuantity());
    }

    private SaleOrder getSaleOrder(CreateSaleRequest createSaleRequest) {
        if (createSaleRequest.getSaleOrderId() == null) return null;
        return saleOrderService.findSaleOrderByIdOrThrowNotFound(createSaleRequest.getSaleOrderId());
    }

}
