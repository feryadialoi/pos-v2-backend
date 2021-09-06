package com.gdi.posbackend.command.impl.saleorder;

import com.gdi.posbackend.command.saleorder.GetSaleOrderCommand;
import com.gdi.posbackend.model.commandparam.GetSaleOrderCommandParam;
import com.gdi.posbackend.model.response.DetailedSaleOrderResponse;
import com.gdi.posbackend.repository.SaleOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/7/2021 2:49 AM
 */
@Component
@AllArgsConstructor
public class GetSaleOrderCommandImpl implements GetSaleOrderCommand {

    private final SaleOrderRepository saleOrderRepository;

    @Override
    public DetailedSaleOrderResponse execute(GetSaleOrderCommandParam getSaleOrderCommandParam) {




        return null;
    }
}
