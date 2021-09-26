package com.gdi.posbackend.command.productstockdetail;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.GetProductStockDetailWithProductStockMutationsCommandParam;
import com.gdi.posbackend.model.response.DetailedProductStockDetailResponse;

/**
 * @author Feryadialoi
 * @date 9/17/2021 2:31 PM
 */
public interface GetProductStockDetailWithProductStockMutationsCommand extends ConsumerSupplierCommand<DetailedProductStockDetailResponse, GetProductStockDetailWithProductStockMutationsCommandParam> {
}
