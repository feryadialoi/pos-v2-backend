package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.ProductStockMutation;
import com.gdi.posbackend.mapper.ProductStockMutationMapper;
import com.gdi.posbackend.mapper.UnitMapper;
import com.gdi.posbackend.model.response.ProductStockMutationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/17/2021 2:36 PM
 */
@Component
public class ProductStockMutationMapperImpl implements ProductStockMutationMapper {

    @Autowired
    private UnitMapper unitMapper;

    @Override
    public ProductStockMutationResponse mapProductStockMutationToProductStockMutationResponse(ProductStockMutation productStockMutation) {
        return new ProductStockMutationResponse(
                productStockMutation.getId(),
                unitMapper.mapUnitToUnitResponse(productStockMutation.getUnit()),
                productStockMutation.getQuantityIn(),
                productStockMutation.getQuantityOut(),
                productStockMutation.getEvent(),
                productStockMutation.getReference()
        );
    }
}
