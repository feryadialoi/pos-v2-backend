package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 9/7/2021 3:06 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductStockDetailResponse {
    private String id;
    private BigDecimal quantity;
    private String batch;
    private ProductStockResponse productStock;
}
