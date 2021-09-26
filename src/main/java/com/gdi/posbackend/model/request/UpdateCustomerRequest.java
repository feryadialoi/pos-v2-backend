package com.gdi.posbackend.model.request;

import lombok.Data;

/**
 * @author Feryadialoi
 * @date 9/14/2021 12:57 PM
 */
@Data
public class UpdateCustomerRequest {

    private String name;

    private String nationalIdentificationNumber;

    private String address;

    private String phone;

    private String phone2;

    private String description;

}
