package com.gdi.posbackend.command.impl.purchase;

import com.gdi.posbackend.command.purchase.CreatePurchaseCommand;
import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import com.gdi.posbackend.entity.enums.PurchaseStatus;
import com.gdi.posbackend.entity.enums.RunningNumberPrefix;
import com.gdi.posbackend.exception.CreatePurchaseNotAllowedException;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/29/2021 4:07 AM
 */
@Slf4j
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

        CreatePurchaseRequest createPurchaseRequest = createPurchaseCommandParam.getCreatePurchaseRequest();

        checkPurchaseOrderStatusIfExists(createPurchaseRequest);

        Purchase purchase = doCreatePurchase(createPurchaseRequest);

//        journalService.postJournalOfPurchase(purchase);

        productStockService.updateProductStockByPurchase(purchase);

        return purchaseMapper.mapPurchaseToDetailedPurchaseResponse(purchase);
    }

    private void checkPurchaseOrderStatusIfExists(CreatePurchaseRequest createPurchaseRequest) throws CreatePurchaseNotAllowedException {
        if (createPurchaseRequest.getPurchaseOrderId() != null) {
            PurchaseOrder purchaseOrder = purchaseOrderService.findPurchaseOrderByIdOrThrowNotFound(createPurchaseRequest.getPurchaseOrderId());
            if (purchaseOrder.getStatus() == PurchaseOrderStatus.DRAFT) {
                throw new CreatePurchaseNotAllowedException("not allowed to create purchase from purchase order with status " + purchaseOrder.getStatus());
            }
            if (purchaseOrder.getStatus() == PurchaseOrderStatus.AWAITING_APPROVAL) {
                throw new CreatePurchaseNotAllowedException("not allowed to create purchase from purchase order with status " + purchaseOrder.getStatus());
            }
            if (purchaseOrder.getStatus() == PurchaseOrderStatus.REFUSED) {
                throw new CreatePurchaseNotAllowedException("not allowed to create purchase from purchase order with status " + purchaseOrder.getStatus());
            }
            if (purchaseOrder.getStatus() == PurchaseOrderStatus.VOID) {
                throw new CreatePurchaseNotAllowedException("not allowed to create purchase from purchase order with status " + purchaseOrder.getStatus());
            }
            if (purchaseOrder.getStatus() == PurchaseOrderStatus.COMPLETE) {
                throw new CreatePurchaseNotAllowedException("not allowed to create purchase from purchase order with status " + purchaseOrder.getStatus());
            }
        }

    }

    @SuppressWarnings("Duplicates")
    private Purchase doCreatePurchase(CreatePurchaseRequest createPurchaseRequest) {
        Purchase purchase = new Purchase();

        if (createPurchaseRequest.getPurchaseOrderId() != null) {
            purchase.setPurchaseOrder(purchaseOrderService.findPurchaseOrderByIdOrThrowNotFound(createPurchaseRequest.getPurchaseOrderId()));

            setPurchaseOrderStatusToComplete(purchase.getPurchaseOrder());

        }
        purchase.setCode(runningNumberCodeUtil.getFormattedCode(runningNumberService.getRunningNumber(RunningNumberPrefix.P)));
        purchase.setReference(createPurchaseRequest.getReference());
        purchase.setSupplier(supplierService.findSupplierByIdOrThrowNotFound(createPurchaseRequest.getSupplierId()));
        purchase.setStatus(createPurchaseRequest.getStatus());
        purchase.setPaymentType(createPurchaseRequest.getPaymentType());
        purchase.setEntryDate(localDateUtil.fromString(createPurchaseRequest.getEntryDate()));

        if (createPurchaseRequest.getPaymentType() == PaymentType.CREDIT) {
            purchase.setDueDate(localDateUtil.fromString(createPurchaseRequest.getDueDate()));
            purchase.setTerm(createPurchaseRequest.getTerm());
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

    @SuppressWarnings("Duplicates")

    private void setPurchaseOrderStatusToComplete(PurchaseOrder purchaseOrder) {
        purchaseOrderService.completePurchaseOrderStatus(purchaseOrder.getId());
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
            purchaseDetail.setTotal(calculateAmount(product));

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
