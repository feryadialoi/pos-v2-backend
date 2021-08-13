package com.gdi.posbackend.command;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandrequest.warehouse.GetWarehouseCommandRequest;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:45 AM
 */
public interface GetWarehouseCommand extends ConsumerSupplierCommand<DetailedWarehouseResponse, GetWarehouseCommandRequest> {
}
