package com.gdi.posbackend.command.impl.product;

import com.gdi.posbackend.command.product.CreateProductCommand;
import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.exception.ProductAlreadyExistsException;
import com.gdi.posbackend.mapper.ProductMapper;
import com.gdi.posbackend.model.commandparam.CreateProductCommandParam;
import com.gdi.posbackend.model.request.CreateProductRequest;
import com.gdi.posbackend.model.request.ProductUnitConversionRequest;
import com.gdi.posbackend.model.response.DetailedProductResponse;
import com.gdi.posbackend.repository.ProductRepository;
import com.gdi.posbackend.service.BrandService;
import com.gdi.posbackend.service.CategoryService;
import com.gdi.posbackend.service.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    // ** mapper
    private final ProductMapper productMapper;

    // ** service
    private final UnitService unitService;
    private final CategoryService categoryService;
    private final BrandService brandService;

    @Override
    public DetailedProductResponse execute(CreateProductCommandParam request) {

        CreateProductRequest createProductRequest = request.getCreateProductRequest();

        checkForIdempotent(createProductRequest.getIdempotentKey());

        Product product = new Product();
        product.setName(createProductRequest.getName());
        product.setCode(createProductRequest.getCode());
        product.setCategory(categoryService.findCategoryByIdOrThrowNotFound(createProductRequest.getCategoryId()));
        product.setBrand(brandService.findBrandByIdOrThrowNotFound(createProductRequest.getBrandId()));
        product.setUnits(unitService.findUnitsByIdsOrThrowNotFound(createProductRequest.getUnitIds()));
        product.setUnitConversions(getUnitConversions(createProductRequest, product));
        product.setStock(BigDecimal.ZERO);
        product.setMinimumStock(BigDecimal.ZERO);
        product.setIdempotentKey(createProductRequest.getIdempotentKey());

        product = productRepository.save(product);

        return productMapper.mapProductToDetailedProductResponse(product);

    }

    private List<UnitConversion> getUnitConversions(CreateProductRequest createProductRequest, Product product) {
        List<UnitConversion> unitConversions = new ArrayList<>();

        for (ProductUnitConversionRequest productUnitConversionRequest : createProductRequest.getUnitConversions()) {
            UnitConversion unitConversion = new UnitConversion();
            unitConversion.setFromUnit(unitService.findUnitByIdOrThrowNotFound(productUnitConversionRequest.getFromUnitId()));
            unitConversion.setMultiplier(productUnitConversionRequest.getMultiplier());
            unitConversion.setToUnit(unitService.findUnitByIdOrThrowNotFound(productUnitConversionRequest.getToUnitId()));
            unitConversion.setProduct(product);
            unitConversions.add(unitConversion);
        }

        return unitConversions;
    }

    private void checkForIdempotent(String idempotentKey) {
        boolean exists = productRepository.existsByIdempotentKey(idempotentKey);
        if (exists) throw new ProductAlreadyExistsException("product already exists with idempotent key " + idempotentKey);
    }

}
