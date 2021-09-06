package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.PurchaseOrder;
import com.gdi.posbackend.model.criteria.PurchaseOrderCriteria;
import com.gdi.posbackend.model.request.CreatePurchaseOrderRequest;
import com.gdi.posbackend.model.request.UpdatePurchaseOrderStatusRequest;
import com.gdi.posbackend.model.response.*;
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

    PurchaseOrder findPurchaseOrderByIdOrThrowNotFound(String purchaseOrderId);

    void completePurchaseOrderStatus(String purchaseOrderId);

    UpdatePurchaseOrderStatusResponse updatePurchaseOrderStatus(String purchaseOrderId, UpdatePurchaseOrderStatusRequest updatePurchaseOrderStatusRequest);
}
