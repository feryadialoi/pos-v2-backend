package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.*;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.commandrequest.warehouse.*;
import com.gdi.posbackend.model.criteria.WarehouseCriteria;
import com.gdi.posbackend.model.request.CreateWarehouseRequest;
import com.gdi.posbackend.model.request.UpdateWarehouseRequest;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseResponse;
import com.gdi.posbackend.repository.WarehouseRepository;
import com.gdi.posbackend.service.ServiceExecutor;
import com.gdi.posbackend.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
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

    private final ServiceExecutor serviceExecutor;
    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;

    @Override
    public Page<WarehouseResponse> getWarehouses(WarehouseCriteria warehouseCriteria, Pageable pageable) {
        return serviceExecutor.execute(GetWarehousesCommand.class,
                new GetWarehousesCommandRequest(warehouseCriteria, pageable)
        );
    }

    @Override
    public DetailedWarehouseResponse getWarehouse(String warehouseId) {
        return serviceExecutor.execute(GetWarehouseCommand.class,
                new GetWarehouseCommandRequest(warehouseId)
        );
    }

    @Override
    public DetailedWarehouseResponse createWarehouse(CreateWarehouseRequest createWarehouseRequest) {
        return serviceExecutor.execute(CreateWarehouseCommand.class,
                new CreateWarehouseCommandRequest(createWarehouseRequest)
        );
    }

    @Override
    public DetailedWarehouseResponse updateWarehouse(String warehouseId, UpdateWarehouseRequest updateWarehouseRequest) {
        return serviceExecutor.execute(UpdateWarehouseCommand.class,
                new UpdateWarehouseCommandRequest(warehouseId, updateWarehouseRequest)
        );
    }

    @Override
    public Object deleteWarehouse(String warehouseId) {
        return serviceExecutor.execute(DeleteWarehouseCommand.class,
                new DeleteWarehouseCommandRequest(warehouseId)
        );
    }

    @Override
    public List<WarehouseResponse> getListWarehouse() {
        return warehouseRepository
                .findAll()
                .stream()
                .map(warehouseMapper::mapWarehouseToWarehouseResponse)
                .collect(Collectors.toList());
    }
}
