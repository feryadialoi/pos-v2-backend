package com.gdi.posbackend.command.product;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.DeleteProductCommandParam;

/**
 * @author Feryadialoi
 * @date 9/10/2021 12:30 AM
 */
public interface DeleteProductCommand extends ConsumerSupplierCommand<Void, DeleteProductCommandParam> {
}
