package com.gdi.posbackend.command.productstock;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.UpdateProductStockByPurchaseCommandParam;

/**
 * @author Feryadialoi
 * @date 8/30/2021 2:27 PM
 */
public interface UpdateProductStockByPurchaseCommand extends ConsumerSupplierCommand<Void, UpdateProductStockByPurchaseCommandParam> {
}
