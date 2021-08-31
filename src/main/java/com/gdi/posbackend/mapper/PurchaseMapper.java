package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.Purchase;
import com.gdi.posbackend.model.response.DetailedPurchaseResponse;
import com.gdi.posbackend.model.response.PurchaseResponse;

/**
 * @author Feryadialoi
 * @date 8/25/2021 4:09 AM
 */
public interface PurchaseMapper {

    PurchaseResponse mapPurchaseToPurchaseResponse(Purchase purchase);

    DetailedPurchaseResponse mapPurchaseToDetailedPurchaseResponse(Purchase purchase);

}
