package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/17/2021 2:25 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailedProductStockDetailResponse {
    private String id;
    private BigDecimal quantity;
    private String batch;
    private List<ProductStockMutationResponse> productStockMutations;
    private ProductStockResponse productStock;

}
