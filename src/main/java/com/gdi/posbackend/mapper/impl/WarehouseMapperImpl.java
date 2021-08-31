package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseResponse;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:42 AM
 */
@Component
public class WarehouseMapperImpl implements WarehouseMapper {
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
}
