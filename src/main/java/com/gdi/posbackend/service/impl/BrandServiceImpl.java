package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.Brand;
import com.gdi.posbackend.exception.BrandDeleteNotAllowedException;
import com.gdi.posbackend.mapper.BrandMapper;
import com.gdi.posbackend.model.criteria.BrandCriteria;
import com.gdi.posbackend.model.request.CreateBrandRequest;
import com.gdi.posbackend.model.request.UpdateBrandRequest;
import com.gdi.posbackend.model.response.BrandResponse;
import com.gdi.posbackend.repository.BrandRepository;
import com.gdi.posbackend.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.gdi.posbackend.specification.BrandSpecification.nameIsLike;

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

        String name = brandCriteria.getName();

        if (name != null) specification = specification.and(nameIsLike(name));

        return brandRepository.findAll(specification, pageable).map(brandMapper::mapBrandToBrandResponse);
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
        return brandMapper.mapBrandToBrandResponse(findBrandByIdOrThrowNotFound(brandId));
    }

    @Override
    public BrandResponse updateBrand(String brandId, UpdateBrandRequest updateBrandRequest) {
        Brand brand = findBrandByIdOrThrowNotFound(brandId);

        if (updateBrandRequest.getName() != null) brand.setName(updateBrandRequest.getName());

        brandRepository.save(brand);

        return brandMapper.mapBrandToBrandResponse(brand);

    }

    @Override
    public String deleteBrand(String brandId) {
        Brand brand = findBrandByIdOrThrowNotFound(brandId);

        if (brandRepository.productCountByBrandId(brandId) > 0 ) {
            throw new BrandDeleteNotAllowedException("brand with id " + brandId + " has relasionship and already used in another table");
        }

        brandRepository.delete(brand);

        return brandId;
    }

    @Override
    public Brand findBrandByIdOrThrowNotFound(String brandId) {
        return brandRepository.findByIdOrThrowNotFound(brandId);
    }
}
