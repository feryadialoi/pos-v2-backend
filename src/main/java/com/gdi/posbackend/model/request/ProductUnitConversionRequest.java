package com.gdi.posbackend.model.request;

import com.gdi.posbackend.validation.constraint.UnitExists;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/5/2021 4:13 PM
 */
@Data
public class ProductUnitConversionRequest {

    @NotBlank
    @UnitExists
    private String fromUnitId;

    @NotNull
    @Min(1)
    private BigDecimal multiplier;

    @NotBlank
    @UnitExists
    private String toUnitId;

}
