package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.PurchaseOrderDetail;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.mapper.PurchaseOrderDetailMapper;
import com.gdi.posbackend.mapper.UnitMapper;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.response.PurchaseOrderDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/23/2021 2:28 PM
 */
@Component
@AllArgsConstructor
public class PurchaseOrderDetailMapperImpl implements PurchaseOrderDetailMapper {

    private final ProductMapper productMapper;
    private final UnitMapper unitMapper;
    private final WarehouseMapper warehouseMapper;

    @Override
    public PurchaseOrderDetailResponse mapPurchaseOrderDetailToPurchaseOrderDetailResponse(PurchaseOrderDetail purchaseOrderDetail) {

        return PurchaseOrderDetailResponse.builder()
                .id(purchaseOrderDetail.getId())
                .product(productMapper.mapProductToProductResponse(purchaseOrderDetail.getProduct()))
                .warehouse(warehouseMapper.mapWarehouseToWarehouseResponse(purchaseOrderDetail.getWarehouse()))
                .unit(unitMapper.mapUnitToUnitResponse(purchaseOrderDetail.getUnit()))
                .price(purchaseOrderDetail.getPrice())
                .quantity(purchaseOrderDetail.getQuantity())
                .tax(purchaseOrderDetail.getTax())
                .taxFormat(purchaseOrderDetail.getTaxFormat())
                .discount(purchaseOrderDetail.getDiscount())
                .discountFormat(purchaseOrderDetail.getDiscountFormat())
                .total(purchaseOrderDetail.getTotal())
                .build();

    }
}
