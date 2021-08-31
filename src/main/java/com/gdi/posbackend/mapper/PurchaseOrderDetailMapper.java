package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.PurchaseOrderDetail;
import com.gdi.posbackend.model.response.PurchaseOrderDetailResponse;

/**
 * @author Feryadialoi
 * @date 8/23/2021 2:27 PM
 */
public interface PurchaseOrderDetailMapper {
    PurchaseOrderDetailResponse mapPurchaseOrderDetailToPurchaseOrderDetailResponse(PurchaseOrderDetail purchaseOrderDetail);
}
