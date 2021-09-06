package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Sale;
import com.gdi.posbackend.mapper.SaleMapper;
import com.gdi.posbackend.model.response.DetailedSaleResponse;
import com.gdi.posbackend.model.response.SaleResponse;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:39 AM
 */
@Component
public class SaleMapperImpl implements SaleMapper {
    @Override
    public DetailedSaleResponse mapSaleToDetailedSaleResponse(Sale sale) {
        return null;
    }

    @Override
    public SaleResponse mapSaleToSaleResponse(Sale sale) {
        return null;
    }
}
