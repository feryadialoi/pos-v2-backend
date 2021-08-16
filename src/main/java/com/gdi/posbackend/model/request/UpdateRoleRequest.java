package com.gdi.posbackend.model.request;

import lombok.Data;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/15/2021 11:29 PM
 */
@Data
public class UpdateRoleRequest {
    private String displayName;
    private String description;
    private List<PermissionOfRoleRequest> permissions;
}
