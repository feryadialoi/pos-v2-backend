package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.mapper.CategoryMapper;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.mapper.UnitMapper;
import com.gdi.posbackend.model.response.DetailedProductResponse;
import com.gdi.posbackend.model.response.ProductResponse;
import com.gdi.posbackend.model.response.ProductUnitConversionResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:46 AM
 */
@Component
@AllArgsConstructor
public class ProductMapperImpl implements ProductMapper {

    private final CategoryMapper categoryMapper;
    private final UnitMapper unitMapper;

    @Override
    public ProductResponse mapProductToProductResponse(Product product) {
        if (product == null) return null;
        return ProductResponse.builder()
                .id(product.getId())
                .code(product.getCode())
                .name(product.getName())
                .category(categoryMapper.mapCategoryToCategoryResponse(product.getCategory()))
                .defaultUnit(product.getDefaultUnit())
                .unitLarge(unitMapper.mapUnitToUnitResponse(product.getUnitLarge()))
                .unitMedium(unitMapper.mapUnitToUnitResponse(product.getUnitMedium()))
                .unitSmall(unitMapper.mapUnitToUnitResponse(product.getUnitSmall()))
                .unitLargePrice(product.getUnitLargePrice())
                .unitMediumPrice(product.getUnitMediumPrice())
                .unitSmallPrice(product.getUnitSmallPrice())
                .unitConversions(product.getUnitConversions().stream().map(unitConversion -> ProductUnitConversionResponse
                        .builder()
                        .fromUnit(unitMapper.mapUnitToUnitResponse(unitConversion.getFromUnit()))
                        .multiplier(unitConversion.getMultiplier())
                        .toUnit(unitMapper.mapUnitToUnitResponse(unitConversion.getToUnit()))
                        .build()).collect(Collectors.toList())
                )
                .build();
    }

    @Override
    public DetailedProductResponse mapProductToDetailedProductResponse(Product product) {
        if (product == null) return null;
        return DetailedProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .build();
    }
}
