package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.exception.ProductNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:37 AM
 */
public interface ProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {

    boolean existsByIdempotentKey(String idempotentKey);

    default Product findByIdOrThrowNotFound(String productId) {
        return findById(productId).orElseThrow(() -> new ProductNotFoundException("product with id " + productId + " not found"));
    }

}
