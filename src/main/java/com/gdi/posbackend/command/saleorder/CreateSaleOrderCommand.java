package com.gdi.posbackend.command.saleorder;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.CreateSaleOrderCommandParam;
import com.gdi.posbackend.model.response.DetailedSaleOrderResponse;

/**
 * @author Feryadialoi
 * @date 9/2/2021 1:25 PM
 */
public interface CreateSaleOrderCommand extends ConsumerSupplierCommand<DetailedSaleOrderResponse, CreateSaleOrderCommandParam> {
}
