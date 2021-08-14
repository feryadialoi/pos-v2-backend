package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.CreateProductCommand;
import com.gdi.posbackend.command.GetProductsCommand;
import com.gdi.posbackend.model.commandrequest.CreateProductCommandRequest;
import com.gdi.posbackend.model.commandrequest.GetProductsCommandRequest;
import com.gdi.posbackend.model.criteria.ProductCriteria;
import com.gdi.posbackend.model.request.CreateProductRequest;
import com.gdi.posbackend.model.request.UpdateProductRequest;
import com.gdi.posbackend.model.response.DetailedProductResponse;
import com.gdi.posbackend.model.response.ProductResponse;
import com.gdi.posbackend.service.ProductService;
import com.gdi.posbackend.service.ServiceExecutor;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:13 AM
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ServiceExecutor serviceExecutor;

    @Override
    public Page<ProductResponse> getProducts(ProductCriteria productCriteria, Pageable pageable) {
        return serviceExecutor.execute(GetProductsCommand.class,
                new GetProductsCommandRequest(productCriteria, pageable)
        );
    }

    @Override
    public DetailedProductResponse getProduct(String productId) {
        return null;
    }

    @Override
    public DetailedProductResponse createProduct(CreateProductRequest createProductRequest) {
        return serviceExecutor.execute(CreateProductCommand.class,
                new CreateProductCommandRequest(createProductRequest)
        );
    }

    @Override
    public DetailedProductResponse updateProduct(String productId, UpdateProductRequest updateProductRequest) {
        return null;
    }

    @Override
    public Object deleteProduct(String productId) {
        return null;
    }
}
