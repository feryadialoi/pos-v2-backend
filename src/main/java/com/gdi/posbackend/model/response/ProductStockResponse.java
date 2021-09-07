package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 9/6/2021 3:11 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductStockResponse {
    private SimplifiedProductResponse product;
    private WarehouseResponse warehouse;
    private BigDecimal stock;
    private UnitResponse unit;
}
