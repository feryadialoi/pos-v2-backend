package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.PurchaseDetail;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.mapper.PurchaseDetailMapper;
import com.gdi.posbackend.mapper.UnitMapper;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.response.PurchaseDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/25/2021 9:52 AM
 */
@Component
public class PurchaseDetailMapperImpl implements PurchaseDetailMapper {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UnitMapper unitMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public PurchaseDetailResponse mapPurchaseDetailToPurchaseDetailResponse(PurchaseDetail purchaseDetail) {
        return PurchaseDetailResponse.builder()
                .id(purchaseDetail.getId())
                .product(productMapper.mapProductToProductResponse(purchaseDetail.getProduct()))
                .warehouse(warehouseMapper.mapWarehouseToWarehouseResponse(purchaseDetail.getWarehouse()))
                .unit(unitMapper.mapUnitToUnitResponse(purchaseDetail.getUnit()))
                .price(purchaseDetail.getPrice())
                .quantity(purchaseDetail.getQuantity())
                .tax(purchaseDetail.getTax())
                .discount(purchaseDetail.getDiscount())
                .total(purchaseDetail.getTotal())
                .build();
    }
}
