package com.gdi.posbackend.model.request;

import com.gdi.posbackend.validation.constraint.BrandExists;
import com.gdi.posbackend.validation.constraint.CategoryExists;
import com.gdi.posbackend.validation.constraint.ProductCodeUnique;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:12 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {

    @ProductCodeUnique
    private String code;

    private String name;

    @BrandExists
    private String brandId;

    @CategoryExists
    private String categoryId;
}
