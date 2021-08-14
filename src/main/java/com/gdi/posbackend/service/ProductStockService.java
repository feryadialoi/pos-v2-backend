package com.gdi.posbackend.service;

import com.gdi.posbackend.model.criteria.ProductStockCriteria;
import com.gdi.posbackend.model.request.UpdateProductStockRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/6/2021 1:48 AM
 */
public interface ProductStockService {
    Page<Object> getProductStocks(ProductStockCriteria productStockCriteria, Pageable pageable);

    Object getProductStock(String productStockId);

    Object updateProductStock(String productStockId, UpdateProductStockRequest updateProductStockRequest);
}
