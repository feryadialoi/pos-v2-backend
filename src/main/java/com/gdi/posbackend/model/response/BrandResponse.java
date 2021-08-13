package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/13/2021 2:12 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandResponse {

    private Long id;
    private String name;

}
