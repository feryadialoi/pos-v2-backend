package com.gdi.posbackend.command.saleorder;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.GetSaleOrdersCommandParam;
import com.gdi.posbackend.model.response.SaleOrderResponse;
import org.springframework.data.domain.Page;

/**
 * @author Feryadialoi
 * @date 9/2/2021 1:28 PM
 */
public interface GetSaleOrdersCommand extends ConsumerSupplierCommand<Page<SaleOrderResponse>, GetSaleOrdersCommandParam> {
}
