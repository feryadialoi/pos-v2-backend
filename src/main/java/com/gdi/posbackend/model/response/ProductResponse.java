package com.gdi.posbackend.model.response;

import com.gdi.posbackend.entity.enums.ProductDefaultUnit;
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
    private Long id;
    private String code;
    private String name;
    private CategoryResponse category;
    private ProductDefaultUnit defaultUnit;
    private UnitResponse unitLarge;
    private UnitResponse unitMedium;
    private UnitResponse unitSmall;
    private BigDecimal unitLargePrice;
    private BigDecimal unitMediumPrice;
    private BigDecimal unitSmallPrice;
    private List<ProductUnitConversionResponse> unitConversions;
}
