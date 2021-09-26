package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.mapper.*;
import com.gdi.posbackend.model.response.DetailedProductStockResponse;
import com.gdi.posbackend.model.response.ProductStockResponse;
import com.gdi.posbackend.model.response.SimplifiedProductStockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 9/6/2021 3:12 PM
 */
@Component
public class ProductStockMapperImpl implements ProductStockMapper {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Autowired
    private UnitMapper unitMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductStockDetailMapper productStockDetailMapper;

    @Override
    public ProductStockResponse mapProductStockToProductStockResponse(ProductStock productStock) {
        return ProductStockResponse.builder()
                .id(productStock.getId())
                .product(productMapper.mapProductToSimplifiedProductResponse(productStock.getProduct()))
                .warehouse(warehouseMapper.mapWarehouseToWarehouseResponse(productStock.getWarehouse()))
                .unit(unitMapper.mapUnitToUnitResponse(productStock.getUnit()))
                .stock(productStock.getStock())
                .build();
    }

    @Override
    public DetailedProductStockResponse mapProductStockToDetailedProductStockResponse(ProductStock productStock) {
        return DetailedProductStockResponse.builder()
                .id(productStock.getId())
                .product(productMapper.mapProductToSimplifiedProductResponse(productStock.getProduct()))
                .stock(productStock.getStock())
                .unit(unitMapper.mapUnitToUnitResponse(productStock.getUnit()))
                .productStockDetails(productStock.getProductStockDetails().stream()
                                             .map(productStockDetailMapper::mapProductStockDetailToSimplifiedProductStockDetailResponse)
                                             .collect(Collectors.toList()))
                .build();
    }

    @Override
    public SimplifiedProductStockResponse mapProductStockToSimplifiedProductStockResponse(ProductStock productStock) {
        return SimplifiedProductStockResponse.builder()
                .id(productStock.getId())
                .product(productMapper.mapProductToSimplifiedProductResponse(productStock.getProduct()))
                .stock(productStock.getStock())
                .unit(unitMapper.mapUnitToUnitResponse(productStock.getUnit()))
                .build();
    }

}
