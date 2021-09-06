package com.gdi.posbackend.command.impl.product;

import com.gdi.posbackend.command.product.GetProductsCommand;
import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.model.commandparam.GetProductsCommandParam;
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

import static com.gdi.posbackend.specification.ProductSpecification.*;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:37 AM
 */
@Transactional
@Component
@AllArgsConstructor
public class
GetProductsCommandImpl implements GetProductsCommand {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Page<ProductResponse> execute(GetProductsCommandParam request) {
        ProductCriteria productCriteria = request.getProductCriteria();
        Pageable pageable = request.getPageable();

        String code = productCriteria.getCode();
        String name = productCriteria.getName();
        String categoryName = productCriteria.getCategoryName();

        Specification<Product> specification = Specification.where(null);

        if (code != null) specification = specification.and(codeIsLike(code));

        if (name != null) specification = specification.and(nameIsLike(name));

        if (categoryName != null) specification = specification.and(categoryNameIsLike(categoryName));

        Page<Product> page = productRepository.findAll(specification, pageable);
        return page.map(productMapper::mapProductToProductResponse);
    }
}
