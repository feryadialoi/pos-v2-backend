package com.gdi.posbackend.command.impl.salereturn;

import com.gdi.posbackend.command.salereturn.GetSaleReturnCommand;
import com.gdi.posbackend.model.commandparam.GetSaleReturnCommandParam;
import com.gdi.posbackend.model.response.DetailedSaleReturnResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:27 PM
 */
@Component
@AllArgsConstructor
public class GetSaleReturnCommandImpl implements GetSaleReturnCommand {
    @Override
    public DetailedSaleReturnResponse execute(GetSaleReturnCommandParam getSaleReturnCommandParam) {
        return null;
    }
}
