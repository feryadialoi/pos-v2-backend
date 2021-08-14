package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:10 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String id;
    private String code;
    private String name;
    private CategoryResponse category;
    private BrandResponse brand;
    private List<UnitResponse> units;
    private List<ProductUnitConversionResponse> unitConversions;
}
