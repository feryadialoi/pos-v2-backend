package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.auth.Role;
import com.gdi.posbackend.mapper.RoleMapper;
import com.gdi.posbackend.model.response.DetailedRoleResponse;
import com.gdi.posbackend.model.response.PermissionResponse;
import com.gdi.posbackend.model.response.RoleResponse;
import com.gdi.posbackend.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/15/2021 11:33 PM
 */
@Component
@AllArgsConstructor
public class RoleMapperImpl implements RoleMapper {


    @Override
    public RoleResponse mapRoleToRoleResponse(Role role) {
        return RoleResponse.builder()
                .id(role.getId())
                .name(role.getName())
                .displayName(role.getDisplayName())
                .description(role.getDescription())
                .build();
    }

    @Override
    public DetailedRoleResponse mapRoleToDetailedRoleResponse(Role role) {
        return DetailedRoleResponse.builder()
                .id(role.getId())
                .name(role.getName())
                .displayName(role.getDisplayName())
                .description(role.getDescription())
                .permissions(role.getPermissions().stream()
                        .map(permission -> PermissionResponse.builder()
                                .id(permission.getId())
                                .name(permission.getName())
                                .displayName(permission.getDisplayName())
                                .description(permission.getDescription())
                                .build())
                        .collect(Collectors.toList())
                )
                .build();
    }


}
