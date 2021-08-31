package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/30/2021 10:18 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponse {
    private String id;
    private String name;
    private String address;
    private String phone;
    private String bankName;
    private String bankBranch;
    private String bankAccountNumber;
    private String taxableFirmName;
    private String taxableFirmAddress;
    private String taxIdentificationNumber;
}
