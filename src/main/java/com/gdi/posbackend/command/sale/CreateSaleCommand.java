package com.gdi.posbackend.command.sale;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.CreateSaleCommandParam;
import com.gdi.posbackend.model.response.DetailedSaleResponse;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:35 AM
 */
public interface CreateSaleCommand extends ConsumerSupplierCommand<DetailedSaleResponse, CreateSaleCommandParam> {
}
