package com.gdi.posbackend.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 8/29/2021 4:08 PM
 */
@Data
public class CreateCompanyRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String phone;

    @NotBlank
    private String bankName;

    @NotBlank
    private String bankBranch;

    @NotBlank
    private String bankAccountNumber;

    @NotBlank
    private String taxableFirmName;

    @NotBlank
    private String taxableFirmAddress;

    @NotBlank
    private String taxIdentificationNumber;
}
