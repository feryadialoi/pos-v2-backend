package com.gdi.posbackend.command.impl.warehouse;

import com.gdi.posbackend.command.warehouse.UpdateWarehouseCommand;
import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.exception.WarehouseNotFoundException;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.commandparam.warehouse.UpdateWarehouseCommandParam;
import com.gdi.posbackend.model.request.UpdateWarehouseRequest;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;
import com.gdi.posbackend.repository.WarehouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:57 AM
 */
@Component
@AllArgsConstructor
public class UpdateWarehouseCommandImpl implements UpdateWarehouseCommand {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;

    @Override
    public DetailedWarehouseResponse execute(UpdateWarehouseCommandParam request) {
        String warehouseId = request.getWarehouseId();
        UpdateWarehouseRequest updateWarehouseRequest = request.getUpdateWarehouseRequest();

        Optional<Warehouse> optional = warehouseRepository.findById(warehouseId);

        if (optional.isEmpty()) throw new WarehouseNotFoundException("warehouse with id " + warehouseId + " not found");

        Warehouse warehouse = optional.get();

        if (updateWarehouseRequest.getName() != null) warehouse.setName(updateWarehouseRequest.getName());
        if (updateWarehouseRequest.getAddress() != null) warehouse.setAddress(updateWarehouseRequest.getAddress());

        warehouse = warehouseRepository.save(warehouse);

        return warehouseMapper.mapWarehouseToDetailedWarehouseResponse(warehouse);
    }
}
