package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.mapper.ProductStockMapper;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseWithDetailedProductStockResponse;
import com.gdi.posbackend.model.response.WarehouseWithProductStocksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:42 AM
 */
@Component
public class WarehouseMapperImpl implements WarehouseMapper {

    @Autowired
    private ProductStockMapper productStockMapper;

    @Override
    public DetailedWarehouseResponse mapWarehouseToDetailedWarehouseResponse(Warehouse warehouse) {
        if (warehouse == null) return null;
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
        if (warehouse == null) return null;
        return WarehouseWithProductStocksResponse.builder()
                .warehouse(mapWarehouseToWarehouseResponse(warehouse))
                .pageOfProductStock(pageOfProductStock.map(productStockMapper::mapProductStockToSimplifiedProductStockResponse))
                .build();
    }

    @Override
    public WarehouseWithDetailedProductStockResponse mapWarehouseToWarehouseWithProductStockResponse(Warehouse warehouse, ProductStock productStock) {
        if (warehouse == null) return null;
        return WarehouseWithDetailedProductStockResponse.builder()
                .warehouse(mapWarehouseToWarehouseResponse(warehouse))
                .productStock(productStockMapper.mapProductStockToProductStockResponse(productStock))
                .build();
    }

}
