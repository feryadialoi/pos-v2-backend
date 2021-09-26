package com.gdi.posbackend.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 8/13/2021 2:11 PM
 */
@Data
public class CreateBrandRequest {
    @NotBlank
    private String name;
}
