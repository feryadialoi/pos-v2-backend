package com.gdi.posbackend.command.impl.warehouse;

import com.gdi.posbackend.command.warehouse.DeleteWarehouseCommand;
import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.exception.WarehouseNotFoundException;
import com.gdi.posbackend.model.commandparam.warehouse.DeleteWarehouseCommandParam;
import com.gdi.posbackend.repository.WarehouseRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        Optional<Warehouse> optional = warehouseRepository.findById(request.getWarehouseId());
        if (optional.isEmpty()) {
            throw new WarehouseNotFoundException("warehouse with id " + request.getWarehouseId() + " not found");
        } else {
            Warehouse warehouse = optional.get();

            List<ProductStock> productStocks = warehouse.getProductStocks();

            log.info(String.valueOf(productStocks));

            return request.getWarehouseId();
        }
    }
}
