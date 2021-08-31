package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.PurchaseOrder;
import com.gdi.posbackend.model.criteria.PurchaseOrderCriteria;
import com.gdi.posbackend.model.request.ApprovePurchaseOrderRequest;
import com.gdi.posbackend.model.request.CreatePurchaseOrderRequest;
import com.gdi.posbackend.model.response.DetailedPurchaseOrderResponse;
import com.gdi.posbackend.model.response.PurchaseOrderResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/18/2021 4:26 PM
 */
public interface PurchaseOrderService {
    Page<PurchaseOrderResponse> getPurchaseOrders(PurchaseOrderCriteria purchaseOrderCriteria, Pageable pageable);

    DetailedPurchaseOrderResponse getPurchaseOrder(String purchaseOrderId);

    DetailedPurchaseOrderResponse createPurchaseOrder(CreatePurchaseOrderRequest createPurchaseOrderRequest);

    Object approvePurchaseOrder(ApprovePurchaseOrderRequest approvePurchaseOrderRequest);

    PurchaseOrder findPurchaseOrderByIdOrThrowNotFound(String purchaseOrderId);
}
