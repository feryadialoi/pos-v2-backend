package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.PurchaseDetail;
import com.gdi.posbackend.model.response.PurchaseDetailResponse;

/**
 * @author Feryadialoi
 * @date 8/25/2021 9:49 AM
 */
public interface PurchaseDetailMapper {
    PurchaseDetailResponse mapPurchaseDetailToPurchaseDetailResponse(PurchaseDetail purchaseDetail);
}
