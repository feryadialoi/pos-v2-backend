package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 9/7/2021 10:08 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductStockOfWarehouseResponse {
    private ProductOfProductStockOfWarehouseResponse product;
    private BigDecimal stock;
    private UnitResponse unit;
}
