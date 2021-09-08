package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.model.response.DetailedProductStockResponse;
import com.gdi.posbackend.model.response.ProductOfProductStockResponse;
import com.gdi.posbackend.model.response.ProductStockResponse;

/**
 * @author Feryadialoi
 * @date 9/6/2021 3:10 PM
 */
public interface ProductStockMapper {
    ProductStockResponse mapProductStockToProductStockResponse(ProductStock productStock);

    DetailedProductStockResponse mapProductStockToDetailedProductStockResponse(ProductStock productStock);
}
