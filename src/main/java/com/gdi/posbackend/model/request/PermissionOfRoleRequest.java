package com.gdi.posbackend.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 8/15/2021 11:30 PM
 */
@Data
public class PermissionOfRoleRequest {

    @NotBlank
    private String id;

    @NotNull
    private Boolean active;
}
