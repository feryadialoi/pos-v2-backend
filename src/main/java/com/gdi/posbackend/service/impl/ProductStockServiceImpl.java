package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.model.criteria.ProductStockCriteria;
import com.gdi.posbackend.model.request.UpdateProductStockRequest;
import com.gdi.posbackend.repository.ProductRepository;
import com.gdi.posbackend.service.ProductStockService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 8/6/2021 2:03 AM
 */
@Service
@AllArgsConstructor
public class ProductStockServiceImpl implements ProductStockService {

    private final ProductRepository productRepository;


    @Override
    public Page<Object> getProductStocks(ProductStockCriteria productStockCriteria, Pageable pageable) {

        Product product = new Product();
        productRepository.findAll(pageable);

        return null;
    }

    @Override
    public Object getProductStock(String productStockId) {
        return null;
    }

    @Override
    public Object updateProductStock(String productStockId, UpdateProductStockRequest updateProductStockRequest) {
        return null;
    }
}
