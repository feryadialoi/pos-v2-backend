package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.warehouse.*;
import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.commandparam.warehouse.*;
import com.gdi.posbackend.model.criteria.WarehouseCriteria;
import com.gdi.posbackend.model.request.CreateWarehouseRequest;
import com.gdi.posbackend.model.request.UpdateWarehouseRequest;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseWithDetailedProductStockResponse;
import com.gdi.posbackend.model.response.WarehouseWithProductStocksResponse;
import com.gdi.posbackend.repository.WarehouseRepository;
import com.gdi.posbackend.service.ProductStockService;
import com.gdi.posbackend.service.ServiceExecutor;
import com.gdi.posbackend.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/4/2021 10:00 PM
 */
@Service
@AllArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    // ** repository
    private final WarehouseRepository warehouseRepository;

    // ** mapper
    private final WarehouseMapper warehouseMapper;

    // ** service
    private final ServiceExecutor serviceExecutor;
    private final ProductStockService productStockService;


    @Override
    public Page<WarehouseResponse> getWarehouses(WarehouseCriteria warehouseCriteria, Pageable pageable) {
        return serviceExecutor.execute(GetWarehousesCommand.class, new GetWarehousesCommandParam(warehouseCriteria, pageable));
    }

    @Override
    public DetailedWarehouseResponse getWarehouse(String warehouseId) {
        return serviceExecutor.execute(GetWarehouseCommand.class, new GetWarehouseCommandParam(warehouseId));
    }

    @Override
    public DetailedWarehouseResponse createWarehouse(CreateWarehouseRequest createWarehouseRequest) {
        return serviceExecutor.execute(CreateWarehouseCommand.class, new CreateWarehouseCommandParam(createWarehouseRequest));
    }

    @Override
    public DetailedWarehouseResponse updateWarehouse(String warehouseId, UpdateWarehouseRequest updateWarehouseRequest) {
        return serviceExecutor.execute(UpdateWarehouseCommand.class, new UpdateWarehouseCommandParam(warehouseId, updateWarehouseRequest));
    }

    @Override
    public Object deleteWarehouse(String warehouseId) {
        return serviceExecutor.execute(DeleteWarehouseCommand.class, new DeleteWarehouseCommandParam(warehouseId));
    }

    @Override
    public List<WarehouseResponse> getListWarehouse() {
        return warehouseRepository
                .findAll()
                .stream()
                .map(warehouseMapper::mapWarehouseToWarehouseResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Warehouse findWarehouseByIdOrThrowNotFound(String warehouseId) {
        return warehouseRepository.findByIdOrThrowNotFound(warehouseId);
    }

    @Override
    public WarehouseWithProductStocksResponse getWarehouseWithProductStocks(String warehouseId, Pageable pageable) {
        Warehouse warehouse = findWarehouseByIdOrThrowNotFound(warehouseId);

        Page<ProductStock> pageOfProductStock = productStockService.getProductStocksByWarehouseId(warehouseId, pageable);

        return warehouseMapper.mapWarehouseToWarehouseWithProductStocksResponse(warehouse, pageOfProductStock);
    }

    @Override
    public WarehouseWithDetailedProductStockResponse getWarehouseWithProductStock(String warehouseId, String productStockId) {
        Warehouse warehouse = findWarehouseByIdOrThrowNotFound(warehouseId);

        ProductStock productStock = productStockService.getProductStockByIdAndWarehouseId(productStockId, warehouseId);

        return warehouseMapper.mapWarehouseToWarehouseWithProductStockResponse(warehouse, productStock);
    }


}
