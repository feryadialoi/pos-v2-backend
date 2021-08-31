package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.Brand;
import com.gdi.posbackend.exception.BrandNotFoundException;
import com.gdi.posbackend.mapper.BrandMapper;
import com.gdi.posbackend.model.criteria.BrandCriteria;
import com.gdi.posbackend.model.request.CreateBrandRequest;
import com.gdi.posbackend.model.request.UpdateBrandRequest;
import com.gdi.posbackend.model.response.BrandResponse;
import com.gdi.posbackend.repository.BrandRepository;
import com.gdi.posbackend.service.BrandService;
import com.gdi.posbackend.specification.BrandSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/13/2021 2:12 PM
 */
@Service
@Transactional
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public Page<BrandResponse> getBrands(BrandCriteria brandCriteria, Pageable pageable) {
        Specification<Brand> specification = Specification.where(null);
        if (brandCriteria.getName() != null) {
            specification = specification.and(BrandSpecification.nameIsLike(brandCriteria.getName()));
        }

        Page<Brand> page = brandRepository.findAll(specification, pageable);
        return page.map(brandMapper::mapBrandToBrandResponse);
    }

    @Override
    public BrandResponse createBrand(CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        brand = brandRepository.save(brand);

        return brandMapper.mapBrandToBrandResponse(brand);
    }

    @Override
    public BrandResponse getBrand(String brandId) {
        Optional<Brand> optionalBrand = brandRepository.findById(brandId);
        if (optionalBrand.isPresent()) {
            Brand brand = optionalBrand.get();
            return brandMapper.mapBrandToBrandResponse(brand);
        } else {
            throw new BrandNotFoundException("Brand with id " + brandId + " not found");
        }
    }

    @Override
    public BrandResponse updateBrand(String brandId, UpdateBrandRequest updateBrandRequest) {
        Optional<Brand> optionalBrand = brandRepository.findById(brandId);
        if (optionalBrand.isPresent()) {
            Brand brand = optionalBrand.get();

            if (updateBrandRequest.getName() != null) {
                brand.setName(updateBrandRequest.getName());
            }

            brand = brandRepository.save(brand);

            return brandMapper.mapBrandToBrandResponse(brand);
        } else {
            throw new BrandNotFoundException("Brand with id " + brandId + " not found");
        }
    }

    @Override
    public String deleteBrand(String brandId) {
        Optional<Brand> optionalBrand = brandRepository.findById(brandId);
        if (optionalBrand.isPresent()) {
            Brand brand = optionalBrand.get();

            brandRepository.delete(brand);

            return brandId;
        } else {
            throw new BrandNotFoundException("Brand with id " + brandId + " not found");
        }
    }

    @Override
    public Brand findBrandByIdOrThrowNotFound(String brandId) {
        return brandRepository.findById(brandId)
                .orElseThrow(() -> new BrandNotFoundException("brand with id " + brandId + " not found"));
    }
}
