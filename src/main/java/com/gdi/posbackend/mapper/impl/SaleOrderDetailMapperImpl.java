package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.SaleOrderDetail;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.mapper.SaleOrderDetailMapper;
import com.gdi.posbackend.mapper.UnitMapper;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.response.SaleOrderDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/15/2021 10:10 AM
 */
@Component
public class SaleOrderDetailMapperImpl implements SaleOrderDetailMapper {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Autowired
    private UnitMapper unitMapper;


    @Override
    public SaleOrderDetailResponse mapSaleOrderDetailToSaleOrderDetailResponse(SaleOrderDetail saleOrderDetail) {
        return SaleOrderDetailResponse.builder()
                .id(saleOrderDetail.getId())
                .product(productMapper.mapProductToProductResponse(saleOrderDetail.getProduct()))
                .warehouse(warehouseMapper.mapWarehouseToWarehouseResponse(saleOrderDetail.getWarehouse()))
                .unit(unitMapper.mapUnitToUnitResponse(saleOrderDetail.getUnit()))
                .quantity(saleOrderDetail.getQuantity())
                .price(saleOrderDetail.getPrice())
                .tax(saleOrderDetail.getTax())
                .taxFormat(saleOrderDetail.getTaxFormat())
                .discount(saleOrderDetail.getDiscount())
                .discountFormat(saleOrderDetail.getDiscountFormat())
                .total(saleOrderDetail.getTotal())
                .build();
    }
}
