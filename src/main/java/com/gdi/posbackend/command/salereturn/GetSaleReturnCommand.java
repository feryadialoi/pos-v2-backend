package com.gdi.posbackend.command.salereturn;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.GetSaleReturnCommandParam;
import com.gdi.posbackend.model.response.DetailedSaleReturnResponse;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:26 PM
 */
public interface GetSaleReturnCommand extends ConsumerSupplierCommand<DetailedSaleReturnResponse, GetSaleReturnCommandParam> {
}
