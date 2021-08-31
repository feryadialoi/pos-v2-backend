package com.gdi.posbackend.command.impl.purchaseorder;

import com.gdi.posbackend.command.purchaseorder.CreatePurchaseOrderCommand;
import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.RunningNumberPrefix;
import com.gdi.posbackend.exception.ProductNotFoundException;
import com.gdi.posbackend.exception.SupplierNotFoundException;
import com.gdi.posbackend.exception.UnitNotFoundException;
import com.gdi.posbackend.exception.WarehouseNotFoundException;
import com.gdi.posbackend.mapper.PurchaseOrderMapper;
import com.gdi.posbackend.model.PurchaseOrderCalculatedResult;
import com.gdi.posbackend.model.commandparam.CreatePurchaseOrderCommandParam;
import com.gdi.posbackend.model.request.CreatePurchaseOrderRequest;
import com.gdi.posbackend.model.request.ProductOfCreatePurchaseOrderRequest;
import com.gdi.posbackend.model.response.DetailedPurchaseOrderResponse;
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
 * @date 8/29/2021 5:28 AM
 */
@Component
@Transactional
@AllArgsConstructor
public class CreatePurchaseOrderCommandImpl implements CreatePurchaseOrderCommand {

    // ** repository
    private final PurchaseOrderRepository purchaseOrderRepository;

    // ** mapper
    private final PurchaseOrderMapper purchaseOrderMapper;

    // ** utility
    private final RunningNumberCodeUtil runningNumberCodeUtil;
    private final LocalDateUtil localDateUtil;
    private final DiscountUtil discountUtil;
    private final TaxUtil taxUtil;

    // ** service
    private final RunningNumberService runningNumberService;
    private final SupplierService supplierService;
    private final ProductService productService;
    private final WarehouseService warehouseService;
    private final UnitService unitService;


    @Override
    public DetailedPurchaseOrderResponse execute(CreatePurchaseOrderCommandParam createPurchaseOrderCommandParam) {

        PurchaseOrder purchaseOrder = doCreatePurchaseOrder(createPurchaseOrderCommandParam);

        return purchaseOrderMapper.mapPurchaseOrderToDetailedPurchaseOrderResponse(purchaseOrder);

    }

    private PurchaseOrder doCreatePurchaseOrder(CreatePurchaseOrderCommandParam createPurchaseOrderCommandParam) {
        CreatePurchaseOrderRequest createPurchaseOrderRequest = createPurchaseOrderCommandParam.getCreatePurchaseOrderRequest();

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setCode(runningNumberCodeUtil.getFormattedCode(runningNumberService.getRunningNumber(RunningNumberPrefix.PO)));
        purchaseOrder.setReference(createPurchaseOrderRequest.getReference());
        purchaseOrder.setSupplier(supplierService.findSupplierByIdOrThrowNotFound(createPurchaseOrderRequest.getSupplierId()));
        purchaseOrder.setStatus(createPurchaseOrderRequest.getStatus());
        purchaseOrder.setPaymentType(createPurchaseOrderRequest.getPaymentType());
        purchaseOrder.setEntryDate(localDateUtil.fromString(createPurchaseOrderRequest.getEntryDate()));
        if (createPurchaseOrderRequest.getPaymentType() == PaymentType.CREDIT) {
            purchaseOrder.setDueDate(localDateUtil.fromString(createPurchaseOrderRequest.getDueDate()));
        }

        PurchaseOrderCalculatedResult purchaseOrderCalculatedResult = calculatePurchaseOrder(createPurchaseOrderRequest, purchaseOrder);
        purchaseOrder.setIsDiscounted(discountUtil.getIsDiscounted(purchaseOrderCalculatedResult.getTotalDiscount()));
        purchaseOrder.setIsTaxed(taxUtil.getIsTaxed(purchaseOrderCalculatedResult.getTotalTax()));
        purchaseOrder.setDiscount(purchaseOrderCalculatedResult.getTotalDiscount());
        purchaseOrder.setTax(purchaseOrderCalculatedResult.getTotalTax());
        purchaseOrder.setTotal(purchaseOrderCalculatedResult.getTotal());
        purchaseOrder.setGrandTotal(purchaseOrderCalculatedResult.getGrandTotal());
        purchaseOrder.setPurchaseOrderDetails(purchaseOrderCalculatedResult.getPurchaseOrderDetails());
        purchaseOrder.setShippingFee(createPurchaseOrderRequest.getShippingFee());
        purchaseOrder.setShippingFeeDescription(createPurchaseOrderRequest.getShippingFeeDescription());
        purchaseOrder.setOtherFee(createPurchaseOrderRequest.getOtherFee());
        purchaseOrder.setOtherFeeDescription(createPurchaseOrderRequest.getOtherFeeDescription());
        purchaseOrder.setNote(createPurchaseOrderRequest.getNote());
        purchaseOrder.setAttachment(getAttachment());

        purchaseOrder = purchaseOrderRepository.save(purchaseOrder);
        return purchaseOrder;
    }

    private PurchaseOrderCalculatedResult calculatePurchaseOrder(CreatePurchaseOrderRequest createPurchaseOrderRequest, PurchaseOrder purchaseOrder) {
        List<PurchaseOrderDetail> purchaseOrderDetails = new ArrayList<>();
        BigDecimal totalTax = BigDecimal.ZERO;
        BigDecimal totalDiscount = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;

        for (ProductOfCreatePurchaseOrderRequest product : createPurchaseOrderRequest.getProducts()) {
            PurchaseOrderDetail purchaseOrderDetail = new PurchaseOrderDetail();
            purchaseOrderDetail.setPurchaseOrder(purchaseOrder);
            purchaseOrderDetail.setWarehouse(warehouseService.findWarehouseByIdOrThrowNotFound(product.getWarehouseId()));
            purchaseOrderDetail.setProduct(productService.findProductByIdOrThrowNotFound(product.getProductId()));
            purchaseOrderDetail.setUnit(unitService.findUnitByIdOrThrowNotFound(product.getUnitId()));
            purchaseOrderDetail.setPrice(product.getPrice());
            purchaseOrderDetail.setQuantity(product.getQuantity());
            purchaseOrderDetail.setTax(product.getTax());
            purchaseOrderDetail.setTaxFormat(product.getTaxFormat());
            purchaseOrderDetail.setDiscount(product.getDiscount());
            purchaseOrderDetail.setDiscountFormat(product.getDiscountFormat());
            purchaseOrderDetail.setAmount(calculateAmount(product));

            purchaseOrderDetails.add(purchaseOrderDetail);

            BigDecimal discount = discountUtil.calculateDiscount(product.getPrice(), product.getDiscountFormat(), product.getDiscount());
            BigDecimal priceAfterDiscount = product.getPrice().subtract(discount);
            BigDecimal tax = taxUtil.calculateTax(priceAfterDiscount, product.getTaxFormat(), product.getTax());

            totalTax = totalTax.add(tax.multiply(product.getQuantity()));
            totalDiscount = totalDiscount.add(discount.multiply(product.getQuantity()));
            total = total.add(product.getPrice().multiply(product.getQuantity()));
        }

        BigDecimal grandTotal = total
                .subtract(totalDiscount)
                .add(totalTax)
                .add(createPurchaseOrderRequest.getShippingFee())
                .add(createPurchaseOrderRequest.getOtherFee());

        return new PurchaseOrderCalculatedResult(purchaseOrderDetails, totalDiscount, totalTax, total, grandTotal);
    }

    private BigDecimal calculateAmount(ProductOfCreatePurchaseOrderRequest product) {
        return product.getPrice().multiply(product.getQuantity());
    }

    private String getAttachment() {
        return null;
    }
}
