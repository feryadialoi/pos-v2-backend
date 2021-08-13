package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Brand;
import com.gdi.posbackend.mapper.BrandMapper;
import com.gdi.posbackend.model.response.BrandResponse;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/13/2021 2:15 PM
 */
@Component
public class BrandMapperImpl implements BrandMapper {
    @Override
    public BrandResponse mapBrandToBrandResponse(Brand brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .build();
    }
}
