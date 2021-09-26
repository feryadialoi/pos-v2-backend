package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Purchase;
import com.gdi.posbackend.mapper.PurchaseDetailMapper;
import com.gdi.posbackend.mapper.PurchaseMapper;
import com.gdi.posbackend.mapper.PurchaseOrderMapper;
import com.gdi.posbackend.mapper.SupplierMapper;
import com.gdi.posbackend.model.response.DetailedPurchaseResponse;
import com.gdi.posbackend.model.response.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/25/2021 4:10 AM
 */
@Component
public class PurchaseMapperImpl implements PurchaseMapper {

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private PurchaseDetailMapper purchaseDetailMapper;

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public PurchaseResponse mapPurchaseToPurchaseResponse(Purchase purchase) {
        return PurchaseResponse.builder()
                .id(purchase.getId())
                .purchaseOrder(Optional.ofNullable(purchase.getPurchaseOrder())
                        .map(purchaseOrderMapper::mapPurchaseOrderToPurchaseOrderResponse)
                        .orElse(null))
                .code(purchase.getCode())
                .entryDate(purchase.getEntryDate())
                .dueDate(purchase.getDueDate())
                .term(purchase.getTerm())
                .supplier(supplierMapper.mapSupplierToSupplierResponse(purchase.getSupplier()))
                .reference(purchase.getReference())
                .note(purchase.getNote())
                .attachment(purchase.getNote())
                .shippingFee(purchase.getShippingFee())
                .shippingFeeDescription(purchase.getShippingFeeDescription())
                .otherFee(purchase.getOtherFee())
                .otherFeeDescription(purchase.getOtherFeeDescription())
                .paymentType(purchase.getPaymentType())
                .discount(purchase.getDiscount())
                .tax(purchase.getTax())
                .total(purchase.getTotal())
                .grandTotal(purchase.getGrandTotal())
                .status(purchase.getStatus())
                .build();
    }

    @Override
    public DetailedPurchaseResponse mapPurchaseToDetailedPurchaseResponse(Purchase purchase) {
        return DetailedPurchaseResponse.builder()
                .id(purchase.getId())
                .purchaseDetails(purchase.getPurchaseDetails().stream()
                        .map(purchaseDetailMapper::mapPurchaseDetailToPurchaseDetailResponse)
                        .collect(Collectors.toList()))
                .purchaseOrder(Optional.ofNullable(purchase.getPurchaseOrder())
                        .map(purchaseOrderMapper::mapPurchaseOrderToPurchaseOrderResponse)
                        .orElse(null))
                .code(purchase.getCode())
                .entryDate(purchase.getEntryDate())
                .dueDate(purchase.getDueDate())
                .term(purchase.getTerm())
                .supplier(supplierMapper.mapSupplierToSupplierResponse(purchase.getSupplier()))
                .reference(purchase.getReference())
                .note(purchase.getNote())
                .attachment(purchase.getNote())
                .shippingFee(purchase.getShippingFee())
                .shippingFeeDescription(purchase.getShippingFeeDescription())
                .otherFee(purchase.getOtherFee())
                .otherFeeDescription(purchase.getOtherFeeDescription())
                .paymentType(purchase.getPaymentType())
                .discount(purchase.getDiscount())
                .tax(purchase.getTax())
                .total(purchase.getTotal())
                .grandTotal(purchase.getGrandTotal())
                .status(purchase.getStatus())
                .build();
    }
}
