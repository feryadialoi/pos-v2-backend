package com.gdi.posbackend.command;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandrequest.warehouse.CreateWarehouseCommandRequest;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:49 AM
 */
public interface CreateWarehouseCommand extends ConsumerSupplierCommand<DetailedWarehouseResponse, CreateWarehouseCommandRequest> {
}
