package com.gdi.posbackend.command.impl;

import com.gdi.posbackend.command.CreateProductCommand;
import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.exception.BrandNotFoundException;
import com.gdi.posbackend.exception.CategoryNotFoundException;
import com.gdi.posbackend.exception.ProductAlreadyExistsException;
import com.gdi.posbackend.exception.UnitNotFoundException;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.model.commandrequest.CreateProductCommandRequest;
import com.gdi.posbackend.model.request.CreateProductRequest;
import com.gdi.posbackend.model.request.ProductUnitConversionRequest;
import com.gdi.posbackend.model.response.DetailedProductResponse;
import com.gdi.posbackend.repository.BrandRepository;
import com.gdi.posbackend.repository.CategoryRepository;
import com.gdi.posbackend.repository.ProductRepository;
import com.gdi.posbackend.repository.UnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/13/2021 1:49 PM
 */
@Component
@Transactional
@AllArgsConstructor
public class CreateProductCommandImpl implements CreateProductCommand {

    // ** repository
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final UnitRepository unitRepository;

    // ** mapper
    private final ProductMapper productMapper;

    @Override
    public DetailedProductResponse execute(CreateProductCommandRequest request) {

        CreateProductRequest createProductRequest = request.getCreateProductRequest();

        checkForIdempotent(createProductRequest.getIdempotentKey());

        Product product = new Product();
        product.setName(createProductRequest.getName());
        product.setCode(createProductRequest.getCode());
        product.setCategory(getCategory(createProductRequest.getCategoryId()));
        product.setBrand(getBrand(createProductRequest.getBrandId()));
        product.setUnits(getUnits(createProductRequest.getUnitIds()));
        product.setUnitConversions(getUnitConversions(createProductRequest, product));
        product.setStock(BigDecimal.ZERO);
        product.setMinimumStock(BigDecimal.ZERO);
        product.setIdempotentKey(createProductRequest.getIdempotentKey());

        product = productRepository.save(product);

        return productMapper.mapProductToDetailedProductResponse(product);

    }

    private List<Unit> getUnits(List<String> unitIds) {
        // there are gap/change or units not valid in count/existence
        return unitRepository.findAllById(unitIds);
    }

    // ** private method of helper

    private Brand getBrand(String brandId) {
        Optional<Brand> optionalBrand = brandRepository.findById(brandId);
        if (optionalBrand.isEmpty()) throw new BrandNotFoundException("brand with id " + brandId + " not found");
        return optionalBrand.get();
    }

    private Category getCategory(String categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isEmpty()) throw new CategoryNotFoundException("category with id "
                + categoryId
                + " not found");
        return optionalCategory.get();
    }

    private List<UnitConversion> getUnitConversions(CreateProductRequest createProductRequest, Product product) {
        List<UnitConversion> unitConversions = new ArrayList<>();

        for (ProductUnitConversionRequest productUnitConversionRequest : createProductRequest.getUnitConversions()) {

            UnitConversion unitConversion = new UnitConversion();
            unitConversion.setFromUnit(getUnit(productUnitConversionRequest.getFromUnitId()));
            unitConversion.setMultiplier(productUnitConversionRequest.getMultiplier());
            unitConversion.setToUnit(getUnit(productUnitConversionRequest.getToUnitId()));
            unitConversion.setProduct(product);

            unitConversions.add(unitConversion);

        }

        return unitConversions;
    }

    private Unit getUnit(String unitId) {
        Optional<Unit> optionalUnit = unitRepository.findById(unitId);
        if (optionalUnit.isEmpty()) throw new UnitNotFoundException("unit with id " + unitId + " not found");
        return optionalUnit.get();
    }

    private void checkForIdempotent(String idempotentKey) {
        boolean exists = productRepository.existsByIdempotentKey(idempotentKey);
        if (exists) throw new ProductAlreadyExistsException("product already exists with idempotent key "
                + idempotentKey);
    }

}
