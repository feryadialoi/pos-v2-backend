package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/7/2021 1:17 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseWithDetailedProductStockResponse {
    private WarehouseResponse warehouse;
    private DetailedProductStockOfWarehouseWithDetailedProductStockResponse productStock;
}
