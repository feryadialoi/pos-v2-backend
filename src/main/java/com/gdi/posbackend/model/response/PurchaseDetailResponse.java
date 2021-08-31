package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/25/2021 9:48 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDetailResponse {
    private String id;
    private ProductResponse product;
    private WarehouseResponse warehouse;
    private UnitResponse unit;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal tax;
    private BigDecimal discount;
    private BigDecimal amount;
}
