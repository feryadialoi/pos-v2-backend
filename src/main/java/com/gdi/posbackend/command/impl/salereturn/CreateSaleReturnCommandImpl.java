package com.gdi.posbackend.command.impl.salereturn;

import com.gdi.posbackend.command.salereturn.CreateSaleReturnCommand;
import com.gdi.posbackend.model.commandparam.CreateSaleReturnCommandParam;
import com.gdi.posbackend.model.response.DetailedSaleReturnResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:25 PM
 */
@Component
@AllArgsConstructor
public class CreateSaleReturnCommandImpl implements CreateSaleReturnCommand {


    @Override
    public DetailedSaleReturnResponse execute(CreateSaleReturnCommandParam createSaleReturnCommandParam) {
        return null;
    }
}
