package com.gdi.posbackend.model.request;

import com.gdi.posbackend.validation.constraint.CategoryExistsConstraint;
import com.gdi.posbackend.validation.constraint.BrandExistsConstraint;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:11 AM
 */
@Data
public class CreateProductRequest {
    @NotNull
    @NotBlank
    private String name;

    private String code;

    @NotNull
    @CategoryExistsConstraint
    private Long categoryId;

    @NotNull
    @BrandExistsConstraint
    private Long brandId;

    @NotNull
    private List<Long> unitIds;

    @NotNull
    private List<ProductUnitConversionRequest> unitConversions;
}
