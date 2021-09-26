package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 9/17/2021 11:14 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimplifiedProductStockDetailResponse {
    private String id;
    private BigDecimal quantity;
    private String batch;
}
