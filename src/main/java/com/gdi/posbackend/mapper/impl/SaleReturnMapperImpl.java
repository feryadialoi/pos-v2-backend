package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.SaleReturn;
import com.gdi.posbackend.mapper.SaleReturnMapper;
import com.gdi.posbackend.model.response.DetailedSaleReturnResponse;
import com.gdi.posbackend.model.response.SaleReturnResponse;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:21 PM
 */
@Component
public class SaleReturnMapperImpl implements SaleReturnMapper {

    @Override
    public SaleReturnResponse mapSaleReturnToSaleReturnResponse(SaleReturn saleReturn) {
        return SaleReturnResponse.builder()

                .build();
    }

    @Override
    public DetailedSaleReturnResponse mapSaleReturnToDetailedSaleReturnResponse(SaleReturn saleReturn) {
        return DetailedSaleReturnResponse.builder()

                .build();
    }

}
