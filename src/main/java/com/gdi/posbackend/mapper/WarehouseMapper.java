package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseResponse;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:41 AM
 */
public interface WarehouseMapper {
    DetailedWarehouseResponse mapWarehouseToDetailedWarehouseResponse(Warehouse warehouse);

    WarehouseResponse mapWarehouseToWarehouseResponse(Warehouse warehouse);
}
