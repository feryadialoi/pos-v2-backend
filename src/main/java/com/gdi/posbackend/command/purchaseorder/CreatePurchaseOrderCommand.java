package com.gdi.posbackend.command.purchaseorder;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.CreatePurchaseOrderCommandParam;
import com.gdi.posbackend.model.response.DetailedPurchaseOrderResponse;

/**
 * @author Feryadialoi
 * @date 8/29/2021 5:27 AM
 */
public interface CreatePurchaseOrderCommand extends ConsumerSupplierCommand<DetailedPurchaseOrderResponse, CreatePurchaseOrderCommandParam> {
}
