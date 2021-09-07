package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.mapper.CategoryMapper;
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

    private final CategoryMapper categoryMapper;
    private final UnitMapper unitMapper;

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
    public WarehouseWithProductStocksResponse mapWarehouseToWarehouseWithProductStocksResponse(Warehouse warehouse, Page<ProductStock> productStocks) {
        return WarehouseWithProductStocksResponse.builder()
                .warehouse(mapWarehouseToWarehouseResponse(warehouse))
                .pageOfProductStock(productStocks.map(this::mapProductStockToProductStockOfWarehouseWithProductStocksResponse))
                .build();
    }

    private ProductStockOfWarehouseWithProductStocksResponse mapProductStockToProductStockOfWarehouseWithProductStocksResponse(ProductStock productStock) {
        return ProductStockOfWarehouseWithProductStocksResponse.builder()
                .product(mapProductToProductOfProductStockOfWarehouseWithProductStocksResponse(productStock.getProduct()))
                .unit(unitMapper.mapUnitToUnitResponse(productStock.getUnit()))
                .stock(productStock.getStock())
                .build();
    }

    private ProductOfProductStockOfWarehouseWithProductStocksResponse mapProductToProductOfProductStockOfWarehouseWithProductStocksResponse(Product product) {
        return ProductOfProductStockOfWarehouseWithProductStocksResponse.builder()
                .name(product.getName())
                .code(product.getCode())
                .category(categoryMapper.mapCategoryToCategoryResponse(product.getCategory()))
                .build();
    }
}
