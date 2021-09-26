package com.gdi.posbackend.model.request;

import com.gdi.posbackend.validation.constraint.CategoryExists;
import com.gdi.posbackend.validation.constraint.BrandExists;
import com.gdi.posbackend.validation.constraint.UnitExists;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:11 AM
 */
@Data
public class CreateProductRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String code;

    @NotBlank
    @CategoryExists
    private String categoryId;

    @NotBlank
    @BrandExists
    private String brandId;

    @NotNull
    @Size(min = 1)
    private List<@UnitExists @NotBlank String> unitIds;

    @Valid
    @NotNull
    @Size(min = 1)
    private List<ProductUnitConversionRequest> unitConversions;

}
