package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.SaleOrder;
import com.gdi.posbackend.mapper.SaleOrderMapper;
import com.gdi.posbackend.model.response.DetailedSaleOrderResponse;
import com.gdi.posbackend.model.response.SaleOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:11 AM
 */
@Component
@AllArgsConstructor
public class SaleOrderMapperImpl implements SaleOrderMapper {


    @Override
    public DetailedSaleOrderResponse mapSaleOrderToDetailedSaleOrderResponse(SaleOrder saleOrder) {
        return null;
    }

    @Override
    public SaleOrderResponse mapSaleOrderToSaleOrderResponse(SaleOrder saleOrder) {
        return null;
    }
}
