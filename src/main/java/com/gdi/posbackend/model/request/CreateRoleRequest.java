package com.gdi.posbackend.model.request;

import lombok.Data;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/15/2021 11:26 PM
 */
@Data
public class CreateRoleRequest {
    private String displayName;
    private String description;
    private List<PermissionOfRoleRequest> permissions;
}
