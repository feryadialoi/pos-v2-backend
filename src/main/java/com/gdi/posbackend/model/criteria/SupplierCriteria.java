package com.gdi.posbackend.model.criteria;

import lombok.Data;

/**
 * @author Feryadialoi
 * @date 8/16/2021 9:54 AM
 */
@Data
public class SupplierCriteria {
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
