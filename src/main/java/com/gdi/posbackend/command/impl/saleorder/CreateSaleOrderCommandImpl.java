package com.gdi.posbackend.command.impl.saleorder;

import com.gdi.posbackend.command.saleorder.CreateSaleOrderCommand;
import com.gdi.posbackend.entity.SaleOrder;
import com.gdi.posbackend.entity.SaleOrderDetail;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.RunningNumberPrefix;
import com.gdi.posbackend.mapper.SaleOrderMapper;
import com.gdi.posbackend.model.SaleOrderCalculatedResult;
import com.gdi.posbackend.model.commandparam.CreateSaleOrderCommandParam;
import com.gdi.posbackend.model.request.CreateSaleOrderRequest;
import com.gdi.posbackend.model.request.ProductOfCreateSaleOrderRequest;
import com.gdi.posbackend.model.response.DetailedSaleOrderResponse;
import com.gdi.posbackend.repository.SaleOrderRepository;
import com.gdi.posbackend.service.*;
import com.gdi.posbackend.util.DiscountUtil;
import com.gdi.posbackend.util.LocalDateUtil;
import com.gdi.posbackend.util.RunningNumberCodeUtil;
import com.gdi.posbackend.util.TaxUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 9/2/2021 1:35 PM
 */
@Component
@Transactional
@AllArgsConstructor
public class CreateSaleOrderCommandImpl implements CreateSaleOrderCommand {

    // ** repository
    private final SaleOrderRepository saleOrderRepository;

    // ** mapper
    private final SaleOrderMapper saleOrderMapper;

    // ** util
    private final RunningNumberCodeUtil runningNumberCodeUtil;
    private final LocalDateUtil localDateUtil;
    private final DiscountUtil discountUtil;
    private final TaxUtil taxUtil;

    // ** service
    private final RunningNumberService runningNumberService;
    private final CustomerService customerService;
    private final SalesmanService salesmanService;
    private final StorageService storageService;
    private final UnitService unitService;
    private final ProductService productService;
    private final WarehouseService warehouseService;


    @Override
    public DetailedSaleOrderResponse execute(CreateSaleOrderCommandParam createSaleOrderCommandParam) {
        CreateSaleOrderRequest createSaleOrderRequest = createSaleOrderCommandParam.getCreateSaleOrderRequest();
        SaleOrder saleOrder = doCreateSaleOrder(createSaleOrderRequest);
        return saleOrderMapper.mapSaleOrderToDetailedSaleOrderResponse(saleOrder);
    }

    @SuppressWarnings("Duplicates")
    private SaleOrder doCreateSaleOrder(CreateSaleOrderRequest createSaleOrderRequest) {
        SaleOrder saleOrder = new SaleOrder();
        saleOrder.setCode(runningNumberCodeUtil.getFormattedCode(runningNumberService.getRunningNumber(RunningNumberPrefix.SO)));
        saleOrder.setReference(createSaleOrderRequest.getReference());
        saleOrder.setCustomer(customerService.findCustomerByIdOrThrowNotFound(createSaleOrderRequest.getCustomerId()));
        saleOrder.setSalesman(salesmanService.findSalesmanByIdOrThrowNotFound(createSaleOrderRequest.getSalesmanId()));
        saleOrder.setStatus(createSaleOrderRequest.getStatus());
        saleOrder.setPaymentType(createSaleOrderRequest.getPaymentType());
        saleOrder.setEntryDate(localDateUtil.fromString(createSaleOrderRequest.getEntryDate()));
        saleOrder.setDueDate(Optional.ofNullable(createSaleOrderRequest.getDueDate()).map(localDateUtil::fromString).orElse(null));
        saleOrder.setTerm(createSaleOrderRequest.getTerm());

        SaleOrderCalculatedResult saleOrderCalculatedResult = calculateSaleOrder(createSaleOrderRequest, saleOrder);

        saleOrder.setIsTaxed(taxUtil.getIsTaxed(saleOrderCalculatedResult.getTotalTax()));
        saleOrder.setTax(saleOrderCalculatedResult.getTotalTax());
        saleOrder.setIsDiscounted(discountUtil.getIsDiscounted(saleOrderCalculatedResult.getTotalDiscount()));
        saleOrder.setDiscount(saleOrderCalculatedResult.getTotalDiscount());
        saleOrder.setTotal(saleOrderCalculatedResult.getTotal());
        saleOrder.setGrandTotal(saleOrderCalculatedResult.getGrandTotal());
        saleOrder.setSaleOrderDetails(saleOrderCalculatedResult.getSaleOrderDetails());
        saleOrder.setShippingFee(createSaleOrderRequest.getShippingFee());
        saleOrder.setShippingFeeDescription(createSaleOrderRequest.getShippingFeeDescription());
        saleOrder.setOtherFee(createSaleOrderRequest.getOtherFee());
        saleOrder.setOtherFeeDescription(createSaleOrderRequest.getOtherFeeDescription());
        saleOrder.setNote(createSaleOrderRequest.getNote());
        saleOrder.setAttachment(storageService.uploadImageFile(null));

        saleOrder = saleOrderRepository.save(saleOrder);
        return saleOrder;
    }

    private SaleOrderCalculatedResult calculateSaleOrder(CreateSaleOrderRequest createSaleOrderRequest, SaleOrder saleOrder) {
        List<SaleOrderDetail> saleOrderDetails = new ArrayList<>();
        BigDecimal totalTax = BigDecimal.ZERO;
        BigDecimal totalDiscount = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;

        for (ProductOfCreateSaleOrderRequest product : createSaleOrderRequest.getProducts()) {
            SaleOrderDetail saleOrderDetail = new SaleOrderDetail();
            saleOrderDetail.setSaleOrder(saleOrder);
            saleOrderDetail.setProduct(productService.findProductByIdOrThrowNotFound(product.getProductId()));
            saleOrderDetail.setUnit(unitService.findUnitByIdOrThrowNotFound(product.getUnitId()));
            saleOrderDetail.setQuantity(product.getQuantity());
            saleOrderDetail.setPrice(product.getPrice());
            saleOrderDetail.setWarehouse(warehouseService.findWarehouseByIdOrThrowNotFound(product.getWarehouseId()));
            saleOrderDetail.setTax(product.getTax());
            saleOrderDetail.setTaxFormat(product.getTaxFormat());
            saleOrderDetail.setDiscount(product.getDiscount());
            saleOrderDetail.setDiscountFormat(product.getDiscountFormat());
            saleOrderDetail.setTotal(calculateSaleOrderDetailTotal(product));

            saleOrderDetails.add(saleOrderDetail);

            BigDecimal discount = discountUtil.calculateDiscount(product.getPrice(), product.getDiscountFormat(), product.getDiscount());
            BigDecimal priceAfterDiscount = product.getPrice().subtract(discount);
            BigDecimal tax = taxUtil.calculateTax(priceAfterDiscount, product.getTaxFormat(), product.getTax());

            totalDiscount = totalDiscount.add(discount);
            totalTax = totalTax.add(tax);
            total = total.add(product.getPrice().multiply(product.getQuantity()));
        }

        BigDecimal grandTotal = total.subtract(totalDiscount)
                .add(totalTax)
                .add(createSaleOrderRequest.getShippingFee())
                .add(createSaleOrderRequest.getOtherFee());

        return new SaleOrderCalculatedResult(
                saleOrderDetails,
                totalDiscount,
                totalTax,
                total,
                grandTotal
        );
    }

    private BigDecimal calculateSaleOrderDetailTotal(ProductOfCreateSaleOrderRequest product) {
        return product.getPrice().multiply(product.getQuantity());
    }
}