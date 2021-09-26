package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.ProductStockMutation;
import com.gdi.posbackend.model.response.ProductStockMutationResponse;

/**
 * @author Feryadialoi
 * @date 9/17/2021 2:35 PM
 */
public interface ProductStockMutationMapper {
    ProductStockMutationResponse mapProductStockMutationToProductStockMutationResponse(ProductStockMutation productStockMutation);
}
