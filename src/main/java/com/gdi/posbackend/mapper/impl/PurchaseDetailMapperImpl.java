package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.PurchaseDetail;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.mapper.PurchaseDetailMapper;
import com.gdi.posbackend.mapper.UnitMapper;
import com.gdi.posbackend.model.response.PurchaseDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 8/25/2021 9:52 AM
 */
@Service
@AllArgsConstructor
public class PurchaseDetailMapperImpl implements PurchaseDetailMapper {

    private final ProductMapper productMapper;
    private final UnitMapper unitMapper;

    @Override
    public PurchaseDetailResponse mapPurchaseDetailToPurchaseDetailResponse(PurchaseDetail purchaseDetail) {
        return PurchaseDetailResponse.builder()
                .id(purchaseDetail.getId())
                .product(productMapper.mapProductToProductResponse(purchaseDetail.getProduct()))
                .unit(unitMapper.mapUnitToUnitResponse(purchaseDetail.getUnit()))
                .price(purchaseDetail.getPrice())
                .quantity(purchaseDetail.getQuantity())
                .tax(purchaseDetail.getTax())
                .discount(purchaseDetail.getDiscount())
                .amount(purchaseDetail.getAmount())
                .build();
    }
}
