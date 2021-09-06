package com.gdi.posbackend.command.impl.saleorder;

import com.gdi.posbackend.command.saleorder.GetSaleOrdersCommand;
import com.gdi.posbackend.model.commandparam.GetSaleOrdersCommandParam;
import com.gdi.posbackend.model.response.SaleOrderResponse;
import com.gdi.posbackend.repository.SaleOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/7/2021 3:38 AM
 */
@Component
@AllArgsConstructor
public class GetSaleOrdersCommandImpl implements GetSaleOrdersCommand {

    private final SaleOrderRepository saleOrderRepository;

    @Override
    public Page<SaleOrderResponse> execute(GetSaleOrdersCommandParam getSaleOrdersCommandParam) {
        return Page.empty();
    }
}
