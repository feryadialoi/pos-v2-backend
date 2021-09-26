package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.SaleOrderDetail;
import com.gdi.posbackend.model.response.SaleOrderDetailResponse;

/**
 * @author Feryadialoi
 * @date 9/15/2021 10:09 AM
 */
public interface SaleOrderDetailMapper {
    SaleOrderDetailResponse mapSaleOrderDetailToSaleOrderDetailResponse(SaleOrderDetail saleOrderDetail);
}
