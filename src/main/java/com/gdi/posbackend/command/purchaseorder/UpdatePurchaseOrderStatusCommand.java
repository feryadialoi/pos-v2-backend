package com.gdi.posbackend.command.purchaseorder;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.UpdatePurchaseOrderStatusCommandParam;
import com.gdi.posbackend.model.response.UpdatePurchaseOrderStatusResponse;

/**
 * @author Feryadialoi
 * @date 9/10/2021 2:30 AM
 */
public interface UpdatePurchaseOrderStatusCommand extends ConsumerSupplierCommand<UpdatePurchaseOrderStatusResponse, UpdatePurchaseOrderStatusCommandParam> {
}
