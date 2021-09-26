package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.SaleDetail;
import com.gdi.posbackend.model.response.SaleDetailResponse;

/**
 * @author Feryadialoi
 * @date 9/17/2021 10:29 AM
 */
public interface SaleDetailMapper {
    SaleDetailResponse mapSaleDetailToSaleDetailResponse(SaleDetail saleDetail);
}
