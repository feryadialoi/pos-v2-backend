package com.gdi.posbackend.model.request;

import com.gdi.posbackend.validation.constraint.CompanyExists;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Feryadialoi
 * @date 9/14/2021 12:44 PM
 */
@Data
public class CreateCustomerRequest {

    @NotBlank
    @ApiModelProperty(required = true)
    private String name;

    @NotBlank
    @ApiModelProperty(required = true)
    private String nationalIdentificationNumber;

    @NotBlank
    @ApiModelProperty(required = true)
    private String address;

    @NotBlank
    @ApiModelProperty(required = true)
    private String phone;

    private String phone2;

    private String description;

}
