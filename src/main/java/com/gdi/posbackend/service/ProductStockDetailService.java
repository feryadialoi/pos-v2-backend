package com.gdi.posbackend.service;

import com.gdi.posbackend.model.criteria.ProductStockDetailCriteria;
import com.gdi.posbackend.model.response.ProductStockDetailResponse;
import com.gdi.posbackend.model.response.DetailedProductStockDetailResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 9/17/2021 2:24 PM
 */
public interface ProductStockDetailService {
    DetailedProductStockDetailResponse getProductStockDetailWithProductStockMutations(String productStockDetailId);

    Page<ProductStockDetailResponse> getProductStockDetails(ProductStockDetailCriteria productStockDetailCriteria, Pageable pageable);
}
