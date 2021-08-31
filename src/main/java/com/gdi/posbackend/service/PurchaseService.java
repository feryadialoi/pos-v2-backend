package com.gdi.posbackend.service;

import com.gdi.posbackend.model.criteria.PurchaseCriteria;
import com.gdi.posbackend.model.request.CreatePurchaseRequest;
import com.gdi.posbackend.model.response.DetailedPurchaseResponse;
import com.gdi.posbackend.model.response.PurchaseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/20/2021 1:43 AM
 */
public interface PurchaseService {

    Page<PurchaseResponse> getPurchases(PurchaseCriteria purchaseCriteria, Pageable pageable);

    DetailedPurchaseResponse createPurchase(CreatePurchaseRequest createPurchaseRequest);

    DetailedPurchaseResponse getPurchase(String purchaseId);
}
