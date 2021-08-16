package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/16/2021 9:51 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponse {
    private String id;
    private String code;
    private String name;
    private String address;

    private String pic;
    private String phone;
    private String email;

    private String taxableFirmName;
    private String taxableFirmAddress;
    private String taxIdentificationNumber;

    private String bankName;
    private String bankBranch;
    private String bankAccountNumber;


}
