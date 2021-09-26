package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.SaleOrder;
import com.gdi.posbackend.model.response.DetailedSaleOrderResponse;
import com.gdi.posbackend.model.response.SaleOrderResponse;
import com.gdi.posbackend.model.response.UpdateSaleOrderStatusResponse;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:10 AM
 */
public interface SaleOrderMapper {
    DetailedSaleOrderResponse mapSaleOrderToDetailedSaleOrderResponse(SaleOrder saleOrder);

    SaleOrderResponse mapSaleOrderToSaleOrderResponse(SaleOrder saleOrder);

    UpdateSaleOrderStatusResponse mapSaleOrderToUpdateSaleOrderStatusResponse(SaleOrder saleOrder);
}
