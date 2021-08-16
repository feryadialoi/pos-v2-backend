package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/15/2021 11:24 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse {
    private String id;
    private String name;
    private String displayName;
    private String description;
}
