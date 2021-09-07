package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.model.response.DetailedProductResponse;
import com.gdi.posbackend.model.response.ProductResponse;
import com.gdi.posbackend.model.response.SimplifiedProductResponse;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:45 AM
 */
public interface ProductMapper {
    ProductResponse mapProductToProductResponse(Product product);

    DetailedProductResponse mapProductToDetailedProductResponse(Product product);

    SimplifiedProductResponse mapProductToSimplifiedProductResponse(Product product);
}
