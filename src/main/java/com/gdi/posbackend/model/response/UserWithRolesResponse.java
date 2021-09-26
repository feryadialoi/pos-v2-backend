package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/14/2021 10:59 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserWithRolesResponse {
    private String id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private Integer loginCount;
    private List<RoleResponse> roles;
}
