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
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    @NotBlank
    private String phone;

    @NotNull
    @NotBlank
    private String bankName;

    @NotNull
    @NotBlank
    private String bankBranch;

    @NotNull
    @NotBlank
    private String bankAccountNumber;

    @NotNull
    @NotBlank
    private String taxableFirmName;

    @NotNull
    @NotBlank
    private String taxableFirmAddress;

    @NotNull
    @NotBlank
    private String taxIdentificationNumber;
}
