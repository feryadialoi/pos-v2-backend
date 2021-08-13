package com.gdi.posbackend.command;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandrequest.warehouse.DeleteWarehouseCommandRequest;

/**
 * @author Feryadialoi
 * @date 8/5/2021 12:01 AM
 */
public interface DeleteWarehouseCommand extends ConsumerSupplierCommand<Long, DeleteWarehouseCommandRequest> {
}
