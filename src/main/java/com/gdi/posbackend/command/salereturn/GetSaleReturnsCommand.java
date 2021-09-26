package com.gdi.posbackend.command.salereturn;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.GetSaleReturnsCommandParam;
import com.gdi.posbackend.model.response.SaleReturnResponse;
import org.springframework.data.domain.Page;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:27 PM
 */
public interface GetSaleReturnsCommand extends ConsumerSupplierCommand<Page<SaleReturnResponse>, GetSaleReturnsCommandParam> {
}
