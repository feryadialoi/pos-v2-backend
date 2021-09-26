package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/7/2021 3:05 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailedProductStockResponse {
    private String id;
    private SimplifiedProductResponse product;
    private UnitResponse unit;
    private BigDecimal stock;
    private List<SimplifiedProductStockDetailResponse> productStockDetails;
}
