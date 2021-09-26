package com.gdi.posbackend.command.impl.sale;

import com.gdi.posbackend.command.sale.GetSaleCommand;
import com.gdi.posbackend.mapper.SaleMapper;
import com.gdi.posbackend.model.commandparam.GetSaleCommandParam;
import com.gdi.posbackend.model.response.DetailedSaleResponse;
import com.gdi.posbackend.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/17/2021 10:55 AM
 */
@Component
@AllArgsConstructor
public class GetSaleCommandImpl implements GetSaleCommand {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    @Override
    public DetailedSaleResponse execute(GetSaleCommandParam getSaleCommandParam) {
        return saleMapper.mapSaleToDetailedSaleResponse(saleRepository.findByIdOrThrowNotFound(getSaleCommandParam.getSaleId()));
    }
}
