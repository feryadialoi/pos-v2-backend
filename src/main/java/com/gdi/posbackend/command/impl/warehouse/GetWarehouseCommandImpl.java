package com.gdi.posbackend.command.impl.warehouse;

import com.gdi.posbackend.command.warehouse.GetWarehouseCommand;
import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.exception.WarehouseNotFoundException;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.commandparam.warehouse.GetWarehouseCommandParam;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;
import com.gdi.posbackend.repository.WarehouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:46 AM
 */
@Component
@AllArgsConstructor
public class GetWarehouseCommandImpl implements GetWarehouseCommand {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;

    @Override
    public DetailedWarehouseResponse execute(GetWarehouseCommandParam request) {
        return warehouseMapper.mapWarehouseToDetailedWarehouseResponse(warehouseRepository.findByIdOrThrowNotFound(request.getWarehouseId()));
    }
}
