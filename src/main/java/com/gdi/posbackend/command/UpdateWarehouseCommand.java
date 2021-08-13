package com.gdi.posbackend.command;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandrequest.warehouse.UpdateWarehouseCommandRequest;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:56 AM
 */
public interface UpdateWarehouseCommand extends ConsumerSupplierCommand<DetailedWarehouseResponse, UpdateWarehouseCommandRequest> {
}
