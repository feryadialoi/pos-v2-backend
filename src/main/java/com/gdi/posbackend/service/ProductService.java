package com.gdi.posbackend.service;

import com.gdi.posbackend.model.criteria.ProductCriteria;
import com.gdi.posbackend.model.request.CreateProductRequest;
import com.gdi.posbackend.model.request.UpdateProductRequest;
import com.gdi.posbackend.model.response.DetailedProductResponse;
import com.gdi.posbackend.model.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:04 AM
 */
public interface ProductService {

     Page<ProductResponse> getProducts(ProductCriteria productCriteria, Pageable pageable);

     DetailedProductResponse getProduct(Long productId);

     DetailedProductResponse createProduct(CreateProductRequest createProductRequest);

     DetailedProductResponse updateProduct(Long productId, UpdateProductRequest updateProductRequest);

     Long deleteProduct(Long productId);
}
