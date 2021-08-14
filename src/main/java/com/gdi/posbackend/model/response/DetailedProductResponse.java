package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:11 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailedProductResponse {
    private String id;
    private String name;
}
