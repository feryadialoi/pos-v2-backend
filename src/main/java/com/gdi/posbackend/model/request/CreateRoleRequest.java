package com.gdi.posbackend.model.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/15/2021 11:26 PM
 */
@Data
public class CreateRoleRequest {

    @NotBlank
    private String displayName;

    @NotBlank
    private String description;

    @Valid
    @NotNull
    @Size(min = 1)
    private List<PermissionOfRoleRequest> permissions;
}
