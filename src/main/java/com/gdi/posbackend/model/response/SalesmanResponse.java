package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/14/2021 4:05 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesmanResponse {
    private String id;
    private CompanyResponse company;
    private String name;
    private String address;
    private String phone;
    private String nationalIdentificationNumber;
}
