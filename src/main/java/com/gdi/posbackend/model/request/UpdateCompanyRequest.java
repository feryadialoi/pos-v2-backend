package com.gdi.posbackend.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Feryadialoi
 * @date 8/29/2021 4:19 PM
 */
@Data
public class UpdateCompanyRequest {

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
