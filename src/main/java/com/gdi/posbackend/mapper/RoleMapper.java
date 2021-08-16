package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.auth.Role;
import com.gdi.posbackend.model.response.DetailedRoleResponse;
import com.gdi.posbackend.model.response.RoleResponse;
import com.gdi.posbackend.repository.RoleRepository;

/**
 * @author Feryadialoi
 * @date 8/15/2021 11:32 PM
 */
public interface RoleMapper {
    RoleResponse mapRoleToRoleResponse(Role role);

    DetailedRoleResponse mapRoleToDetailedRoleResponse(Role role);
}
