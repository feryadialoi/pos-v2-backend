package com.gdi.posbackend.model.request;

import com.gdi.posbackend.validation.constraint.CompanyExists;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Feryadialoi
 * @date 9/14/2021 4:19 PM
 */
@Data
public class CreateSalesmanRequest {

    @NotBlank
    String name;

    @NotBlank
    String address;

    @NotBlank
    String phone;

    @NotBlank
    @CompanyExists
    String companyId;

    @NotBlank
    String nationalIdentificationNumber;

}
