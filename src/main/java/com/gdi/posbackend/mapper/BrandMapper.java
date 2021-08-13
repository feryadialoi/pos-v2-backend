package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.Brand;
import com.gdi.posbackend.model.response.BrandResponse;

/**
 * @author Feryadialoi
 * @date 8/13/2021 2:15 PM
 */
public interface BrandMapper {
    BrandResponse mapBrandToBrandResponse(Brand brand);
}
