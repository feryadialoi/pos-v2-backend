package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 9/7/2021 1:18 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailedProductStockOfWarehouseWithDetailedProductStockResponse {
    private String id;
    private SimplifiedProductResponse product;
    private UnitResponse unit;
    private BigDecimal stock;
}
