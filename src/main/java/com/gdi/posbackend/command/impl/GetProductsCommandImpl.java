package com.gdi.posbackend.command.impl;

import com.gdi.posbackend.command.GetProductsCommand;
import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.model.commandrequest.GetProductsCommandRequest;
import com.gdi.posbackend.model.criteria.ProductCriteria;
import com.gdi.posbackend.model.response.ProductResponse;
import com.gdi.posbackend.repository.ProductRepository;
import com.gdi.posbackend.specification.ProductSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:37 AM
 */
@Transactional
@Component
@AllArgsConstructor
public class GetProductsCommandImpl implements GetProductsCommand {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Page<ProductResponse> execute(GetProductsCommandRequest request) {
        ProductCriteria productCriteria = request.getProductCriteria();
        Pageable pageable = request.getPageable();

        Specification<Product> specification = Specification.where(null);

        if (productCriteria.getCode() != null)
            specification = specification.and(ProductSpecification.codeIsLike(productCriteria.getCode()));

        if (productCriteria.getName() != null)
            specification = specification.and(ProductSpecification.nameIsLike(productCriteria.getName()));

        if (productCriteria.getCategoryName() != null) {
            specification = specification.and(ProductSpecification.categoryNameIsLike(productCriteria.getCategoryName()));
        }

        Page<Product> page = productRepository.findAll(specification, pageable);
        return page.map(productMapper::mapProductToProductResponse);
    }
}
