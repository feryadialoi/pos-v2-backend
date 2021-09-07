package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/6/2021 4:15 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductOfProductStockResponse {
    private String id;
    private String name;
    private String code;
    private CategoryResponse category;
}
