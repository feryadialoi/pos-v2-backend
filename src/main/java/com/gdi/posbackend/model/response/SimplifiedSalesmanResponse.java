package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/15/2021 12:01 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimplifiedSalesmanResponse {
    private String id;
    private String name;
    private String address;
    private String phone;
    private String nationalIdentificationNumber;
}
