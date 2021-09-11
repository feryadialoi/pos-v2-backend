package com.gdi.posbackend.command.impl.product;

import com.gdi.posbackend.command.product.UpdateProductCommand;
import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.model.commandparam.UpdateProductCommandParam;
import com.gdi.posbackend.model.request.UpdateProductRequest;
import com.gdi.posbackend.model.response.DetailedProductResponse;
import com.gdi.posbackend.repository.ProductRepository;
import com.gdi.posbackend.service.BrandService;
import com.gdi.posbackend.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Feryadialoi
 * @date 9/10/2021 1:47 AM
 */
@Component
@Transactional
@AllArgsConstructor
public class UpdateProductCommandImpl implements UpdateProductCommand {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final BrandService brandService;
    private final CategoryService categoryService;

    @Override
    public DetailedProductResponse execute(UpdateProductCommandParam updateProductCommandParam) {
        String               productId            = updateProductCommandParam.getProductId();
        UpdateProductRequest updateProductRequest = updateProductCommandParam.getUpdateProductRequest();

        Product product = productRepository.findByIdOrThrowNotFound(productId);

        if (updateProductRequest.getCode() != null) product.setCode(updateProductRequest.getCode());
        if (updateProductRequest.getName() != null) product.setName(updateProductRequest.getName());
        if (updateProductRequest.getBrandId() != null) product.setBrand(brandService.findBrandByIdOrThrowNotFound(updateProductRequest.getBrandId()));
        if (updateProductRequest.getCategoryId() != null) product.setCategory(categoryService.findCategoryByIdOrThrowNotFound(updateProductRequest.getCategoryId()));

        // TODO update unit
        // TODO update unit conversion

        product = productRepository.save(product);

        return productMapper.mapProductToDetailedProductResponse(product);
    }
}
