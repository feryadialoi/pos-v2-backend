package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.product.CreateProductCommand;
import com.gdi.posbackend.command.product.GetProductsCommand;
import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.exception.ProductNotFoundException;
import com.gdi.posbackend.model.commandparam.CreateProductCommandParam;
import com.gdi.posbackend.model.commandparam.GetProductsCommandParam;
import com.gdi.posbackend.model.criteria.ProductCriteria;
import com.gdi.posbackend.model.request.CreateProductRequest;
import com.gdi.posbackend.model.request.UpdateProductRequest;
import com.gdi.posbackend.model.response.DetailedProductResponse;
import com.gdi.posbackend.model.response.ProductResponse;
import com.gdi.posbackend.repository.ProductRepository;
import com.gdi.posbackend.service.ProductService;
import com.gdi.posbackend.service.ServiceExecutor;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:13 AM
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ServiceExecutor serviceExecutor;
    private final ProductRepository productRepository;

    @Override
    public Page<ProductResponse> getProducts(ProductCriteria productCriteria, Pageable pageable) {
        return serviceExecutor.execute(GetProductsCommand.class, new GetProductsCommandParam(productCriteria, pageable));
    }

    @Override
    public DetailedProductResponse getProduct(String productId) {
        return null;
    }

    @Override
    public DetailedProductResponse createProduct(CreateProductRequest createProductRequest) {
        return serviceExecutor.execute(CreateProductCommand.class, new CreateProductCommandParam(createProductRequest));
    }

    @Override
    public DetailedProductResponse updateProduct(String productId, UpdateProductRequest updateProductRequest) {
        return null;
    }

    @Override
    public Object deleteProduct(String productId) {
        return null;
    }

    @Override
    public Product findProductByIdOrThrowNotFound(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("product with id " + productId + " not found"));
    }
}
