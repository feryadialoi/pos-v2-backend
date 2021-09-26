package com.gdi.posbackend.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 8/16/2021 10:21 AM
 */
@Data
public class CreateSupplierRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String pic;

    @NotBlank
    private String phone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String taxableFirmName;

    @NotBlank
    private String taxableFirmAddress;

    @NotBlank
    private String taxIdentificationNumber;

    @NotBlank
    private String bankName;

    @NotBlank
    private String bankBranch;

    @NotBlank
    private String bankAccountNumber;

}
