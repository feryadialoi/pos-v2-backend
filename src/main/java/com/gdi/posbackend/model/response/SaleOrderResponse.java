package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/18/2021 11:52 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrderResponse {
    private String id;
}
