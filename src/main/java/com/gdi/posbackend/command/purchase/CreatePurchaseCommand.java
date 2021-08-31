package com.gdi.posbackend.command.purchase;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.CreatePurchaseCommandParam;
import com.gdi.posbackend.model.response.DetailedPurchaseResponse;

/**
 * @author Feryadialoi
 * @date 8/29/2021 4:06 AM
 */
public interface CreatePurchaseCommand extends ConsumerSupplierCommand<DetailedPurchaseResponse, CreatePurchaseCommandParam> {
}
