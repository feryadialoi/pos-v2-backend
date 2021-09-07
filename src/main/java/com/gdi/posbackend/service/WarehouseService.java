package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.model.criteria.WarehouseCriteria;
import com.gdi.posbackend.model.request.CreateWarehouseRequest;
import com.gdi.posbackend.model.request.UpdateWarehouseRequest;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseWithProductStocksResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/4/2021 9:59 PM
 */
public interface WarehouseService {
    Page<WarehouseResponse> getWarehouses(WarehouseCriteria warehouseCriteria, Pageable pageable);

    DetailedWarehouseResponse getWarehouse(String warehouseId);

    DetailedWarehouseResponse createWarehouse(CreateWarehouseRequest createWarehouseRequest);

    DetailedWarehouseResponse updateWarehouse(String warehouseId, UpdateWarehouseRequest updateWarehouseRequest);

    Object deleteWarehouse(String warehouseId);

    List<WarehouseResponse> getListWarehouse();

    Warehouse findWarehouseByIdOrThrowNotFound(String warehouseId);

    WarehouseWithProductStocksResponse getWarehouseWithProductStocks(String warehouseId, Pageable pageable);
}
