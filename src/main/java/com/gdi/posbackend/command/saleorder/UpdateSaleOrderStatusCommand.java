package com.gdi.posbackend.command.saleorder;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.UpdateSaleOrderStatusCommandParam;
import com.gdi.posbackend.model.response.UpdateSaleOrderStatusResponse;

/**
 * @author Feryadialoi
 * @date 9/16/2021 1:23 PM
 */
public interface UpdateSaleOrderStatusCommand extends ConsumerSupplierCommand<UpdateSaleOrderStatusResponse, UpdateSaleOrderStatusCommandParam> {
}
