package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.mapper.CategoryMapper;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.mapper.UnitMapper;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.response.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:42 AM
 */
@Component
@AllArgsConstructor
public class WarehouseMapperImpl implements WarehouseMapper {


    private final UnitMapper unitMapper;
    private final ProductMapper productMapper;

    @Override
    public DetailedWarehouseResponse mapWarehouseToDetailedWarehouseResponse(Warehouse warehouse) {
        return DetailedWarehouseResponse.builder()
                .id(warehouse.getId())
                .name(warehouse.getName())
                .address(warehouse.getAddress())
                .build();
    }

    @Override
    public WarehouseResponse mapWarehouseToWarehouseResponse(Warehouse warehouse) {
        if (warehouse == null) return null;
        return WarehouseResponse.builder()
                .id(warehouse.getId())
                .name(warehouse.getName())
                .address(warehouse.getAddress())
                .build();
    }

    @Override
    public WarehouseWithProductStocksResponse mapWarehouseToWarehouseWithProductStocksResponse(Warehouse warehouse, Page<ProductStock> pageOfProductStock) {
        return WarehouseWithProductStocksResponse.builder()
                .warehouse(mapWarehouseToWarehouseResponse(warehouse))
                .pageOfProductStock(pageOfProductStock.map(this::mapProductStockToProductStockOfWarehouseWithProductStocksResponse))
                .build();
    }

    @Override
    public WarehouseWithDetailedProductStockResponse mapWarehouseToWarehouseWithProductStockResponse(Warehouse warehouse, ProductStock productStock) {
        return WarehouseWithDetailedProductStockResponse.builder()
                .warehouse(mapWarehouseToWarehouseResponse(warehouse))
                .productStock(mapProductStockToDetailedProductStockOfWarehouseWithDetailedProductStockResponse(productStock))
                .build();
    }

    private DetailedProductStockOfWarehouseWithDetailedProductStockResponse mapProductStockToDetailedProductStockOfWarehouseWithDetailedProductStockResponse(ProductStock productStock) {
        return DetailedProductStockOfWarehouseWithDetailedProductStockResponse.builder()
                .id(productStock.getId())
                .product(productMapper.mapProductToSimplifiedProductResponse(productStock.getProduct()))
                .stock(productStock.getStock())
                .unit(unitMapper.mapUnitToUnitResponse(productStock.getUnit()))
                .build();
    }

    private ProductStockOfWarehouseWithProductStocksResponse mapProductStockToProductStockOfWarehouseWithProductStocksResponse(ProductStock productStock) {
        return ProductStockOfWarehouseWithProductStocksResponse.builder()
                .id(productStock.getId())
                .product(productMapper.mapProductToSimplifiedProductResponse(productStock.getProduct()))
                .unit(unitMapper.mapUnitToUnitResponse(productStock.getUnit()))
                .stock(productStock.getStock())
                .build();
    }
}
