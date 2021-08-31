package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.Brand;
import com.gdi.posbackend.model.criteria.BrandCriteria;
import com.gdi.posbackend.model.request.CreateBrandRequest;
import com.gdi.posbackend.model.request.UpdateBrandRequest;
import com.gdi.posbackend.model.response.BrandResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/13/2021 2:11 PM
 */
public interface BrandService {
    Page<BrandResponse> getBrands(BrandCriteria brandCriteria, Pageable pageable);

    BrandResponse createBrand(CreateBrandRequest createBrandRequest);

    BrandResponse getBrand(String brandId);

    BrandResponse updateBrand(String brandId, UpdateBrandRequest updateBrandRequest);

    String deleteBrand(String brandId);

    Brand findBrandByIdOrThrowNotFound(String brandId);
}
