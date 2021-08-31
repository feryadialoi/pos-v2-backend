package com.gdi.posbackend.command.warehouse;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.warehouse.UpdateWarehouseCommandParam;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:56 AM
 */
public interface UpdateWarehouseCommand extends ConsumerSupplierCommand<DetailedWarehouseResponse, UpdateWarehouseCommandParam> {
}
