package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/7/2021 10:09 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductOfProductStockOfWarehouseResponse {
    private String name;
    private String code;
    private CategoryResponse category;
}
