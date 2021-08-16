package com.gdi.posbackend.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 8/16/2021 1:38 PM
 */
@Data
public class UpdateSupplierRequest {

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
