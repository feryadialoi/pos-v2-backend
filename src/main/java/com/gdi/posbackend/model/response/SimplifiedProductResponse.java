package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/7/2021 1:23 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimplifiedProductResponse {
    private String id;
    private String name;
    private String code;
    private CategoryResponse category;
}
