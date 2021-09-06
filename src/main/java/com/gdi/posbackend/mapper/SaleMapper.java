package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.Sale;
import com.gdi.posbackend.model.response.DetailedSaleResponse;
import com.gdi.posbackend.model.response.SaleResponse;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:38 AM
 */
public interface SaleMapper
{
    DetailedSaleResponse mapSaleToDetailedSaleResponse(Sale sale);

    SaleResponse mapSaleToSaleResponse(Sale sale);
}
