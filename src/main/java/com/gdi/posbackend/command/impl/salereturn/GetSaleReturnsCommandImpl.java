package com.gdi.posbackend.command.impl.salereturn;

import com.gdi.posbackend.command.salereturn.GetSaleReturnsCommand;
import com.gdi.posbackend.model.commandparam.GetSaleReturnsCommandParam;
import com.gdi.posbackend.model.response.SaleReturnResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:29 PM
 */
@Component
@AllArgsConstructor
public class GetSaleReturnsCommandImpl implements GetSaleReturnsCommand {
    @Override
    public Page<SaleReturnResponse> execute(GetSaleReturnsCommandParam getSaleReturnsCommandParam) {
        return null;
    }
}
