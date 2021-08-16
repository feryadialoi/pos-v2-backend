package com.gdi.posbackend.model.request;

import lombok.Data;

/**
 * @author Feryadialoi
 * @date 8/15/2021 11:30 PM
 */
@Data
public class PermissionOfRoleRequest {
    private String id;
    private Boolean active;
}
