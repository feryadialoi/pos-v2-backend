package com.gdi.posbackend.service;

import com.gdi.posbackend.model.criteria.PurchaseReturnCriteria;
import com.gdi.posbackend.model.request.CreatePurchaseReturnRequest;
import com.gdi.posbackend.model.response.DetailedPurchaseReturnResponse;
import com.gdi.posbackend.model.response.PurchaseReturnResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:32 PM
 */
public interface PurchaseReturnService {
    Page<PurchaseReturnResponse> getPurchaseReturns(PurchaseReturnCriteria purchaseReturnCriteria, Pageable pageable);

    DetailedPurchaseReturnResponse getPurchaseReturn(String purchaseReturnId);

    DetailedPurchaseReturnResponse createPurchaseReturn(CreatePurchaseReturnRequest createPurchaseReturnRequest);
}
