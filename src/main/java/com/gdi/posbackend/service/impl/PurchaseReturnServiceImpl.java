package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.purchasereturn.GetPurchaseReturnsCommand;
import com.gdi.posbackend.model.commandparam.GetPurchaseReturnsCommandParam;
import com.gdi.posbackend.model.criteria.PurchaseReturnCriteria;
import com.gdi.posbackend.model.request.CreatePurchaseReturnRequest;
import com.gdi.posbackend.model.response.DetailedPurchaseReturnResponse;
import com.gdi.posbackend.model.response.PurchaseReturnResponse;
import com.gdi.posbackend.service.PurchaseReturnService;
import com.gdi.posbackend.service.ServiceExecutor;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:37 PM
 */
@Service
@AllArgsConstructor
public class PurchaseReturnServiceImpl implements PurchaseReturnService {

    private final ServiceExecutor serviceExecutor;

    @Override
    public Page<PurchaseReturnResponse> getPurchaseReturns(PurchaseReturnCriteria purchaseReturnCriteria, Pageable pageable) {
        return serviceExecutor.execute(GetPurchaseReturnsCommand.class, new GetPurchaseReturnsCommandParam(purchaseReturnCriteria, pageable));
    }

    @Override
    public DetailedPurchaseReturnResponse getPurchaseReturn(String purchaseReturnId) {
        return null;
    }

    @Override
    public DetailedPurchaseReturnResponse createPurchaseReturn(CreatePurchaseReturnRequest createPurchaseReturnRequest) {
        return null;
    }
}
