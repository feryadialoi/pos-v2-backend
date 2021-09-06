package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.PurchaseOrder;
import com.gdi.posbackend.model.response.*;

/**
 * @author Feryadialoi
 * @date 8/23/2021 2:14 PM
 */
public interface PurchaseOrderMapper {
    DetailedPurchaseOrderResponse mapPurchaseOrderToDetailedPurchaseOrderResponse(PurchaseOrder purchaseOrder);

    PurchaseOrderResponse mapPurchaseOrderToPurchaseOrderResponse(PurchaseOrder purchaseOrder);

    UpdatePurchaseOrderStatusResponse mapPurchaseOrderToUpdatePurchaseOrderStatusResponse(PurchaseOrder purchaseOrder);
}
