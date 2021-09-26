package com.gdi.posbackend.command.sale;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.GetSaleCommandParam;
import com.gdi.posbackend.model.response.DetailedSaleResponse;

/**
 * @author Feryadialoi
 * @date 9/17/2021 10:54 AM
 */
public interface GetSaleCommand extends ConsumerSupplierCommand<DetailedSaleResponse, GetSaleCommandParam> {
}
