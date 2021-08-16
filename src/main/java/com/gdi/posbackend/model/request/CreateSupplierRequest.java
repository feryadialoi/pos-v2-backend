package com.gdi.posbackend.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 8/16/2021 10:21 AM
 */
@Data
public class CreateSupplierRequest {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    @NotBlank
    private String pic;

    @NotNull
    @NotBlank
    private String phone;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String taxableFirmName;

    @NotNull
    @NotBlank
    private String taxableFirmAddress;

    @NotNull
    @NotBlank
    private String taxIdentificationNumber;

    @NotNull
    @NotBlank
    private String bankName;

    @NotNull
    @NotBlank
    private String bankBranch;

    @NotNull
    @NotBlank
    private String bankAccountNumber;

}
