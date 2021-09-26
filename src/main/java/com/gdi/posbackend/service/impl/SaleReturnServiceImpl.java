package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.salereturn.CreateSaleReturnCommand;
import com.gdi.posbackend.command.salereturn.GetSaleReturnCommand;
import com.gdi.posbackend.command.salereturn.GetSaleReturnsCommand;
import com.gdi.posbackend.model.commandparam.CreateSaleReturnCommandParam;
import com.gdi.posbackend.model.commandparam.GetSaleReturnCommandParam;
import com.gdi.posbackend.model.commandparam.GetSaleReturnsCommandParam;
import com.gdi.posbackend.model.criteria.SaleReturnCriteria;
import com.gdi.posbackend.model.request.CreateSaleReturnRequest;
import com.gdi.posbackend.model.response.DetailedSaleReturnResponse;
import com.gdi.posbackend.model.response.SaleReturnResponse;
import com.gdi.posbackend.service.SaleReturnService;
import com.gdi.posbackend.service.ServiceExecutor;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:19 PM
 */
@Service
@AllArgsConstructor
public class SaleReturnServiceImpl implements SaleReturnService {

    private final ServiceExecutor serviceExecutor;

    @Override
    public Page<SaleReturnResponse> getSaleReturns(SaleReturnCriteria saleReturnCriteria, Pageable pageable) {
        return serviceExecutor.execute(GetSaleReturnsCommand.class, new GetSaleReturnsCommandParam(saleReturnCriteria, pageable));
    }

    @Override
    public DetailedSaleReturnResponse getSaleReturn(String saleReturnId) {
        return serviceExecutor.execute(GetSaleReturnCommand.class, new GetSaleReturnCommandParam(saleReturnId));
    }

    @Override
    public DetailedSaleReturnResponse createSaleReturn(CreateSaleReturnRequest createSaleReturnRequest) {
        return serviceExecutor.execute(CreateSaleReturnCommand.class, new CreateSaleReturnCommandParam(createSaleReturnRequest));
    }
}
