package com.gdi.posbackend.command.salereturn;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.CreateSaleReturnCommandParam;
import com.gdi.posbackend.model.response.DetailedSaleReturnResponse;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:24 PM
 */
public interface CreateSaleReturnCommand extends ConsumerSupplierCommand<DetailedSaleReturnResponse, CreateSaleReturnCommandParam> {
}
