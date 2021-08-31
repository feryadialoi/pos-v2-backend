package com.gdi.posbackend.command.warehouse;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.warehouse.DeleteWarehouseCommandParam;

/**
 * @author Feryadialoi
 * @date 8/5/2021 12:01 AM
 */
public interface DeleteWarehouseCommand extends ConsumerSupplierCommand<String, DeleteWarehouseCommandParam> {
}
