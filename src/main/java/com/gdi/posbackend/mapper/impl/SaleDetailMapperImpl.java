package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.SaleDetail;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.mapper.SaleDetailMapper;
import com.gdi.posbackend.mapper.UnitMapper;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.response.SaleDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/17/2021 10:29 AM
 */
@Component
public class SaleDetailMapperImpl implements SaleDetailMapper {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Autowired
    private UnitMapper unitMapper;


    @Override
    public SaleDetailResponse mapSaleDetailToSaleDetailResponse(SaleDetail saleDetail) {
        return SaleDetailResponse.builder()
                .id(saleDetail.getId())
                .product(productMapper.mapProductToProductResponse(saleDetail.getProduct()))
                .warehouse(warehouseMapper.mapWarehouseToWarehouseResponse(saleDetail.getWarehouse()))
                .unit(unitMapper.mapUnitToUnitResponse(saleDetail.getUnit()))
                .quantity(saleDetail.getQuantity())
                .price(saleDetail.getPrice())
                .tax(saleDetail.getTax())
                .discount(saleDetail.getDiscount())
                .total(saleDetail.getTotal())
                .build();
    }
}
