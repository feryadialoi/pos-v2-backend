package com.gdi.posbackend.command.impl.productstockdetail;

import com.gdi.posbackend.command.productstockdetail.GetProductStockDetailsCommand;
import com.gdi.posbackend.entity.ProductStockDetail;
import com.gdi.posbackend.mapper.ProductStockDetailMapper;
import com.gdi.posbackend.model.commandparam.GetProductStockDetailsCommandParam;
import com.gdi.posbackend.model.criteria.ProductStockDetailCriteria;
import com.gdi.posbackend.model.response.ProductStockDetailResponse;
import com.gdi.posbackend.repository.ProductStockDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import static com.gdi.posbackend.specification.ProductStockDetailSpecification.*;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 * @author Feryadialoi
 * @date 9/17/2021 3:20 PM
 */
@Component
@AllArgsConstructor
public class GetProductStockDetailsCommandImpl implements GetProductStockDetailsCommand {

    private final ProductStockDetailRepository productStockDetailRepository;
    private final ProductStockDetailMapper productStockDetailMapper;

    @Override
    public Page<ProductStockDetailResponse> execute(GetProductStockDetailsCommandParam getProductStockDetailsCommandParam) {
        ProductStockDetailCriteria productStockDetailCriteria = getProductStockDetailsCommandParam.getProductStockDetailCriteria();
        Pageable pageable = getProductStockDetailsCommandParam.getPageable();

        Specification<ProductStockDetail> specification = where(null);

        if (productStockDetailCriteria.getProductName() != null) specification = specification.and(productNameIsLike(productStockDetailCriteria.getProductName()));
        if (productStockDetailCriteria.getBatch() != null) specification = specification.and(batchIsLike(productStockDetailCriteria.getBatch()));
        if (productStockDetailCriteria.getProductStockId() != null) specification = specification.and(productStockIdIs(productStockDetailCriteria.getProductStockId()));
        if (productStockDetailCriteria.getQuantity() != null) specification = specification.and(quantityIs(productStockDetailCriteria.getQuantity()));
        if (productStockDetailCriteria.getQuantityGe() != null) specification = specification.and(quantityGe(productStockDetailCriteria.getQuantityGe()));
        if (productStockDetailCriteria.getQuantityGt() != null) specification = specification.and(quantityGt(productStockDetailCriteria.getQuantityGt()));
        if (productStockDetailCriteria.getQuantityLe() != null) specification = specification.and(quantityLe(productStockDetailCriteria.getQuantityLe()));
        if (productStockDetailCriteria.getQuantityLt() != null) specification = specification.and(quantityLt(productStockDetailCriteria.getQuantityLt()));

        return productStockDetailRepository.findAll(specification, pageable).map(productStockDetailMapper::mapProductStockDetailToProductStockDetailResponse);


    }
}
