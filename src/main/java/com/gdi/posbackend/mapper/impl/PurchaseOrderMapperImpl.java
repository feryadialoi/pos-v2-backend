package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.PurchaseOrder;
import com.gdi.posbackend.mapper.PurchaseOrderDetailMapper;
import com.gdi.posbackend.mapper.PurchaseOrderMapper;
import com.gdi.posbackend.mapper.SupplierMapper;
import com.gdi.posbackend.model.response.DetailedPurchaseOrderResponse;
import com.gdi.posbackend.model.response.PurchaseOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/23/2021 2:15 PM
 */
@Component
@AllArgsConstructor
public class PurchaseOrderMapperImpl implements PurchaseOrderMapper {

    private final SupplierMapper supplierMapper;
    private final PurchaseOrderDetailMapper purchaseOrderDetailMapper;

    @Override
    public DetailedPurchaseOrderResponse mapPurchaseOrderToDetailedPurchaseOrderResponse(PurchaseOrder purchaseOrder) {
        return DetailedPurchaseOrderResponse.builder()
                .id(purchaseOrder.getId())
                .code(purchaseOrder.getCode())
                .reference(purchaseOrder.getReference())
                .entryDate(purchaseOrder.getEntryDate())
                .dueDate(purchaseOrder.getDueDate())
                .supplier(supplierMapper.mapSupplierToSupplierResponse(purchaseOrder.getSupplier()))
                .paymentType(purchaseOrder.getPaymentType())
                .purchaseOrderDetails(purchaseOrder.getPurchaseOrderDetails().stream()
                        .map(purchaseOrderDetailMapper::mapPurchaseOrderDetailToPurchaseOrderDetailResponse)
                        .collect(Collectors.toList())
                )
                .otherFee(purchaseOrder.getOtherFee())
                .otherFeeDescription(purchaseOrder.getOtherFeeDescription())
                .shippingFee(purchaseOrder.getShippingFee())
                .shippingFeeDescription(purchaseOrder.getShippingFeeDescription())
                .note(purchaseOrder.getNote())
                .attachment(purchaseOrder.getAttachment())
                .discount(purchaseOrder.getDiscount())
                .tax(purchaseOrder.getTax())
                .total(purchaseOrder.getTotal())
                .grandTotal(purchaseOrder.getGrandTotal())
                .status(purchaseOrder.getStatus())
                .build();

    }

    @Override
    public PurchaseOrderResponse mapPurchaseOrderToPurchaseOrderResponse(PurchaseOrder purchaseOrder) {
        if (purchaseOrder == null) return null;
        return PurchaseOrderResponse.builder()
                .id(purchaseOrder.getId())
                .code(purchaseOrder.getCode())
                .reference(purchaseOrder.getReference())
                .entryDate(purchaseOrder.getEntryDate())
                .dueDate(purchaseOrder.getDueDate())
                .supplier(supplierMapper.mapSupplierToSupplierResponse(purchaseOrder.getSupplier()))
                .paymentType(purchaseOrder.getPaymentType())
                .otherFee(purchaseOrder.getOtherFee())
                .otherFeeDescription(purchaseOrder.getOtherFeeDescription())
                .shippingFee(purchaseOrder.getShippingFee())
                .shippingFeeDescription(purchaseOrder.getShippingFeeDescription())
                .note(purchaseOrder.getNote())
                .attachment(purchaseOrder.getAttachment())
                .discount(purchaseOrder.getDiscount())
                .tax(purchaseOrder.getTax())
                .total(purchaseOrder.getTotal())
                .grandTotal(purchaseOrder.getGrandTotal())
                .status(purchaseOrder.getStatus())
                .build();
    }
}
