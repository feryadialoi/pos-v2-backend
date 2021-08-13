package com.gdi.posbackend.service;

import com.gdi.posbackend.model.criteria.WarehouseCriteria;
import com.gdi.posbackend.model.request.CreateWarehouseRequest;
import com.gdi.posbackend.model.request.UpdateWarehouseRequest;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/4/2021 9:59 PM
 */
public interface WarehouseService {
    Page<WarehouseResponse> getWarehouses(WarehouseCriteria warehouseCriteria, Pageable pageable);

    DetailedWarehouseResponse getWarehouse(Long warehouseId);

    DetailedWarehouseResponse createWarehouse(CreateWarehouseRequest createWarehouseRequest);

    DetailedWarehouseResponse updateWarehouse(Long warehouseId, UpdateWarehouseRequest updateWarehouseRequest);

    Long deleteWarehouse(Long warehouseId);
}
