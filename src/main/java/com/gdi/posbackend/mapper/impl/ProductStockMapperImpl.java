package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.entity.ProductStockDetail;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.mapper.ProductStockMapper;
import com.gdi.posbackend.mapper.UnitMapper;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.response.DetailedProductStockResponse;
import com.gdi.posbackend.model.response.ProductStockDetailResponse;
import com.gdi.posbackend.model.response.ProductStockResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 9/6/2021 3:12 PM
 */
@Component
@AllArgsConstructor
public class ProductStockMapperImpl implements ProductStockMapper {

    private final WarehouseMapper warehouseMapper;
    private final UnitMapper unitMapper;
    private final ProductMapper productMapper;

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
                .product(productMapper.mapProductToProductResponse(productStock.getProduct()))
                .stock(productStock.getStock())
                .unit(unitMapper.mapUnitToUnitResponse(productStock.getUnit()))
                .productStockDetails(
                        productStock.getProductStockDetails().stream()
                                .map(this::mapProductStockDetailToProductStockDetailResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }

    private ProductStockDetailResponse mapProductStockDetailToProductStockDetailResponse(ProductStockDetail productStockDetail) {
        return ProductStockDetailResponse.builder()
                .id(productStockDetail.getId())
                .batch(productStockDetail.getBatch())
                .quantity(productStockDetail.getQuantity())
                .build();
    }

}
