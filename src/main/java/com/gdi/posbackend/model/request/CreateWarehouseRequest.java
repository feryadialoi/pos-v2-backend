package com.gdi.posbackend.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Feryadialoi
 * @date 8/4/2021 10:05 PM
 */
@Data
public class CreateWarehouseRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

}
