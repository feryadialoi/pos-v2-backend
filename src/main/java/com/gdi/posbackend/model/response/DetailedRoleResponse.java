package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/15/2021 11:25 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailedRoleResponse {
    private String id;
    private String name;
    private String displayName;
    private String description;
    private List<PermissionResponse> permissions;
}
