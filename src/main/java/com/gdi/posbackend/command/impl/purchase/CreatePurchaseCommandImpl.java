package com.gdi.posbackend.command.impl.purchase;

import com.gdi.posbackend.command.purchase.CreatePurchaseCommand;
import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.RunningNumberPrefix;
import com.gdi.posbackend.mapper.PurchaseMapper;
import com.gdi.posbackend.model.PurchaseCalculatedResult;
import com.gdi.posbackend.model.commandparam.CreatePurchaseCommandParam;
import com.gdi.posbackend.model.request.CreatePurchaseRequest;
import com.gdi.posbackend.model.request.ProductOfCreatePurchaseRequest;
import com.gdi.posbackend.model.response.DetailedPurchaseResponse;
import com.gdi.posbackend.repository.*;
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

/**
 * @author Feryadialoi
 * @date 8/29/2021 4:07 AM
 */
@Component
@Transactional
@AllArgsConstructor
public class CreatePurchaseCommandImpl implements CreatePurchaseCommand {

    // ** repository
    private final PurchaseRepository purchaseRepository;

    // ** mapper
    private final PurchaseMapper purchaseMapper;

    // ** util
    private final RunningNumberCodeUtil runningNumberCodeUtil;
    private final LocalDateUtil localDateUtil;
    private final DiscountUtil discountUtil;
    private final TaxUtil taxUtil;

    // ** service
    private final RunningNumberService runningNumberService;
    private final JournalService journalService;
    private final ProductStockService productStockService;
    private final WarehouseService warehouseService;
    private final ProductService productService;
    private final UnitService unitService;
    private final SupplierService supplierService;
    private final PurchaseOrderService purchaseOrderService;


    @Override
    public DetailedPurchaseResponse execute(CreatePurchaseCommandParam createPurchaseCommandParam) {

        // TODO create purchase
        Purchase purchase = doCreatePurchase(createPurchaseCommandParam.getCreatePurchaseRequest());

        // TODO posting journal
        journalService.postJournalOfPurchase(purchase);

        // TODO mutate stock
        productStockService.updateProductStockByPurchase(purchase);

        return purchaseMapper.mapPurchaseToDetailedPurchaseResponse(purchase);
    }

    private Purchase doCreatePurchase(CreatePurchaseRequest createPurchaseRequest) {
        Purchase purchase = new Purchase();

        if (createPurchaseRequest.getPurchaseOrderId() != null) {
            purchase.setPurchaseOrder(purchaseOrderService.findPurchaseOrderByIdOrThrowNotFound(createPurchaseRequest.getPurchaseOrderId()));
        }
        purchase.setCode(runningNumberCodeUtil.getFormattedCode(runningNumberService.getRunningNumber(RunningNumberPrefix.P)));
        purchase.setReference(createPurchaseRequest.getReference());
        purchase.setSupplier(supplierService.findSupplierByIdOrThrowNotFound(createPurchaseRequest.getSupplierId()));
        purchase.setStatus(createPurchaseRequest.getStatus());
        purchase.setPaymentType(createPurchaseRequest.getPaymentType());
        purchase.setEntryDate(localDateUtil.fromString(createPurchaseRequest.getEntryDate()));
        if (createPurchaseRequest.getPaymentType() == PaymentType.CREDIT) {
            purchase.setDueDate(localDateUtil.fromString(createPurchaseRequest.getDueDate()));
        }
        PurchaseCalculatedResult purchaseCalculatedResult = calculatePurchase(createPurchaseRequest, purchase);
        purchase.setIsDiscounted(discountUtil.getIsDiscounted(purchaseCalculatedResult.getTotalDiscount()));
        purchase.setIsTaxed(taxUtil.getIsTaxed(purchaseCalculatedResult.getTotalTax()));
        purchase.setDiscount(purchaseCalculatedResult.getTotalDiscount());
        purchase.setTax(purchaseCalculatedResult.getTotalTax());
        purchase.setTotal(purchaseCalculatedResult.getTotal());
        purchase.setGrandTotal(purchaseCalculatedResult.getGrandTotal());
        purchase.setPurchaseDetails(purchaseCalculatedResult.getPurchaseDetails());
        purchase.setShippingFee(createPurchaseRequest.getShippingFee());
        purchase.setShippingFeeDescription(createPurchaseRequest.getShippingFeeDescription());
        purchase.setOtherFee(createPurchaseRequest.getOtherFee());
        purchase.setOtherFeeDescription(createPurchaseRequest.getOtherFeeDescription());
        purchase.setNote(createPurchaseRequest.getNote());
        purchase.setAttachment(getAttachment());

        purchase = purchaseRepository.save(purchase);

        return purchase;
    }

    private PurchaseCalculatedResult calculatePurchase(CreatePurchaseRequest createPurchaseRequest, Purchase purchase) {
        List<PurchaseDetail> purchaseDetails = new ArrayList<>();
        BigDecimal totalTax = BigDecimal.ZERO;
        BigDecimal totalDiscount = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;

        for (ProductOfCreatePurchaseRequest product : createPurchaseRequest.getProducts()) {
            PurchaseDetail purchaseDetail = new PurchaseDetail();
            purchaseDetail.setPurchase(purchase);
            purchaseDetail.setWarehouse(warehouseService.findWarehouseByIdOrThrowNotFound(product.getWarehouseId()));
            purchaseDetail.setProduct(productService.findProductByIdOrThrowNotFound(product.getProductId()));
            purchaseDetail.setUnit(unitService.findUnitByIdOrThrowNotFound(product.getUnitId()));
            purchaseDetail.setPrice(product.getPrice());
            purchaseDetail.setQuantity(product.getQuantity());
            purchaseDetail.setTax(product.getTax());
            purchaseDetail.setDiscount(product.getDiscount());
            purchaseDetail.setAmount(calculateAmount(product));

            purchaseDetails.add(purchaseDetail);

            BigDecimal discount = discountUtil.calculateDiscount(product.getPrice(), product.getDiscountFormat(), product.getDiscount());
            BigDecimal tax = taxUtil.calculateTax(product.getPrice().subtract(discount), product.getTaxFormat(), product.getTax());

            totalTax = totalTax.add(tax.multiply(product.getQuantity()));
            totalDiscount = totalDiscount.add(discount.multiply(product.getQuantity()));
            total = total.add(product.getPrice().multiply(product.getQuantity()));
        }

        BigDecimal grandTotal = total
                .subtract(totalDiscount)
                .add(totalTax)
                .add(createPurchaseRequest.getShippingFee())
                .add(createPurchaseRequest.getOtherFee());

        return new PurchaseCalculatedResult(purchaseDetails, totalDiscount, totalTax, total, grandTotal);
    }

    private BigDecimal calculateAmount(ProductOfCreatePurchaseRequest product) {
        return product.getPrice().multiply(product.getQuantity());
    }

    private String getAttachment() {
        return null;
    }
}
