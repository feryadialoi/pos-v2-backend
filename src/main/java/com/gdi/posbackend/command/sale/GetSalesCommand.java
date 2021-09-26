package com.gdi.posbackend.command.sale;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.GetSalesCommandParam;
import com.gdi.posbackend.model.response.SaleResponse;
import org.springframework.data.domain.Page;

/**
 * @author Feryadialoi
 * @date 9/15/2021 12:17 PM
 */
public interface GetSalesCommand extends ConsumerSupplierCommand<Page<SaleResponse>, GetSalesCommandParam> {
}
