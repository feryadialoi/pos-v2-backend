package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.mapper.BrandMapper;
import com.gdi.posbackend.mapper.CategoryMapper;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.mapper.UnitMapper;
import com.gdi.posbackend.model.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:46 AM
 */
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private UnitMapper unitMapper;
    @Autowired
    private BrandMapper brandMapper;

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
                        .id(unitConversion.getId())
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
        System.out.println(product);
        return DetailedProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .build();
    }

    @Override
    public SimplifiedProductResponse mapProductToSimplifiedProductResponse(Product product) {
        if (product == null) return null;
        return SimplifiedProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .category(categoryMapper.mapCategoryToCategoryResponse(product.getCategory()))
                .code(product.getCode())
                .build();
    }
}
