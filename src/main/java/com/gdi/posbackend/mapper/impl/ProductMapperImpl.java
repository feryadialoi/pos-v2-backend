package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.mapper.BrandMapper;
import com.gdi.posbackend.mapper.CategoryMapper;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.mapper.UnitMapper;
import com.gdi.posbackend.model.response.DetailedProductResponse;
import com.gdi.posbackend.model.response.ProductResponse;
import com.gdi.posbackend.model.response.ProductUnitConversionResponse;
import com.gdi.posbackend.model.response.UnitResponse;
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
    private final BrandMapper brandMapper;

    @Override
    public ProductResponse mapProductToProductResponse(Product product) {
        if (product == null) return null;
        return ProductResponse.builder()
                .id(product.getId())
                .code(product.getCode())
                .name(product.getName())
                .category(categoryMapper.mapCategoryToCategoryResponse(product.getCategory()))
                .brand(brandMapper.mapBrandToBrandResponse(product.getBrand()))
                .units(product.getUnits().stream().map(unit -> UnitResponse
                        .builder()
                        .id(unit.getId())
                        .name(unit.getName())
                        .build()).collect(Collectors.toList()))
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
