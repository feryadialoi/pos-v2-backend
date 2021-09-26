package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 9/17/2021 10:17 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetailResponse {
    private String id;
    private ProductResponse product;
    private WarehouseResponse warehouse;
    private UnitResponse unit;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal tax;
    private BigDecimal discount;
    private BigDecimal total;
}
