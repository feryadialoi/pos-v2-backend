package com.gdi.posbackend.command.impl;

import com.gdi.posbackend.command.CreateWarehouseCommand;
import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.commandrequest.warehouse.CreateWarehouseCommandRequest;
import com.gdi.posbackend.model.request.CreateWarehouseRequest;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;
import com.gdi.posbackend.repository.WarehouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:53 AM
 */
@Component
@AllArgsConstructor
public class CreateWarehouseCommandImpl implements CreateWarehouseCommand {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;

    @Override
    public DetailedWarehouseResponse execute(CreateWarehouseCommandRequest request) {
        CreateWarehouseRequest createWarehouseRequest = request.getCreateWarehouseRequest();

        Warehouse warehouse = new Warehouse();
        warehouse.setName(createWarehouseRequest.getName());
        warehouse.setAddress(createWarehouseRequest.getAddress());
        warehouse = warehouseRepository.save(warehouse);

        return warehouseMapper.mapWarehouseToDetailedWarehouseResponse(warehouse);
    }
}
