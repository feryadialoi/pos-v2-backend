package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.SaleReturn;
import com.gdi.posbackend.model.response.DetailedSaleReturnResponse;
import com.gdi.posbackend.model.response.SaleReturnResponse;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:20 PM
 */
public interface SaleReturnMapper {
    SaleReturnResponse mapSaleReturnToSaleReturnResponse(SaleReturn saleReturn);

    DetailedSaleReturnResponse mapSaleReturnToDetailedSaleReturnResponse(SaleReturn saleReturn);
}
