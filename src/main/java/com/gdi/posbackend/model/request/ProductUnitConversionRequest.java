package com.gdi.posbackend.model.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/5/2021 4:13 PM
 */
@Data
public class ProductUnitConversionRequest {
    private String fromUnitId;
    private BigDecimal multiplier;
    private String toUnitId;
}
