package com.gdi.posbackend.command.impl.warehouse;

import com.gdi.posbackend.command.warehouse.DeleteWarehouseCommand;
import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.exception.WarehouseDeleteNotAllowedException;
import com.gdi.posbackend.model.commandparam.warehouse.DeleteWarehouseCommandParam;
import com.gdi.posbackend.repository.WarehouseRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Feryadialoi
 * @date 8/5/2021 12:03 AM
 */
@Slf4j
@Transactional
@Component
@AllArgsConstructor
public class DeleteWarehouseCommandImpl implements DeleteWarehouseCommand {

    private final WarehouseRepository warehouseRepository;

    @Override
    public String execute(DeleteWarehouseCommandParam request) {

        if (warehouseRepository.productStockCountByWarehouseId(request.getWarehouseId()) > 0) {
            throw new WarehouseDeleteNotAllowedException("warehouse with id " + request.getWarehouseId()
                    + " has relationship and already used in another table");
        }

        Warehouse warehouse = warehouseRepository.findByIdOrThrowNotFound(request.getWarehouseId());

        warehouseRepository.delete(warehouse);

        return request.getWarehouseId();

    }
}
