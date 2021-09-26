package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.ProductStockDetail;
import com.gdi.posbackend.model.response.ProductStockDetailResponse;
import com.gdi.posbackend.model.response.DetailedProductStockDetailResponse;
import com.gdi.posbackend.model.response.SimplifiedProductStockDetailResponse;

/**
 * @author Feryadialoi
 * @date 9/17/2021 2:33 PM
 */
public interface ProductStockDetailMapper {

    DetailedProductStockDetailResponse mapProductStockDetailToDetailedProductStockDetailResponse(ProductStockDetail productStockDetail);

    ProductStockDetailResponse mapProductStockDetailToProductStockDetailResponse(ProductStockDetail productStockDetail);

    SimplifiedProductStockDetailResponse mapProductStockDetailToSimplifiedProductStockDetailResponse(ProductStockDetail productStockDetail);
}
