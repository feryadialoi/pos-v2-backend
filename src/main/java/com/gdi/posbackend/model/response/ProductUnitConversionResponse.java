package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:14 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductUnitConversionResponse {
    private UnitResponse fromUnit;
    private BigDecimal multiplier;
    private UnitResponse toUnit;
}
