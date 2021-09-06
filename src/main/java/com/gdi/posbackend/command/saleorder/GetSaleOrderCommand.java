package com.gdi.posbackend.command.saleorder;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.GetSaleOrderCommandParam;
import com.gdi.posbackend.model.response.DetailedSaleOrderResponse;

/**
 * @author Feryadialoi
 * @date 9/2/2021 1:32 PM
 */
public interface GetSaleOrderCommand extends ConsumerSupplierCommand<DetailedSaleOrderResponse, GetSaleOrderCommandParam> {
}
