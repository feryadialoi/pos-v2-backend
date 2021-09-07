package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/7/2021 3:44 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseWithProductStocksResponse {
    private WarehouseResponse warehouse;
    private Page<ProductStockOfWarehouseResponse> pageOfProductStock;
}
