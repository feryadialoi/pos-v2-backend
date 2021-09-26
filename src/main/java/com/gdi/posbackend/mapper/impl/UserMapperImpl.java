package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.auth.Permission;
import com.gdi.posbackend.entity.auth.Role;
import com.gdi.posbackend.entity.auth.User;
import com.gdi.posbackend.mapper.RoleMapper;
import com.gdi.posbackend.mapper.UserMapper;
import com.gdi.posbackend.model.response.RoleResponse;
import com.gdi.posbackend.model.response.SimplifiedUserResponse;
import com.gdi.posbackend.model.response.UserResponse;
import com.gdi.posbackend.model.response.UserWithRolesResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/7/2021 11:57 PM
 */
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserResponse mapUserToUserResponse(User user) {
        List<Role> listOfRole = Optional.ofNullable(user.getRoles()).orElse(Collections.emptyList());

        List<String> roles = listOfRole.stream().map(Role::getName).collect(Collectors.toList());

        List<String> permissions = listOfRole.stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(Permission::getName).distinct()
                .collect(Collectors.toList());

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .username(user.getUsername())
                .roles(roles)
                .permissions(permissions)
                .build();
    }

    @Override
    public UserWithRolesResponse mapUserToUserWithRolesResponse(User user) {
        List<RoleResponse> roles = user.getRoles().stream()
                .map(roleMapper::mapRoleToRoleResponse)
                .collect(Collectors.toList());

        return UserWithRolesResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getName())
                .phone(user.getPhone())
                .roles(roles)
                .build();
    }

    @Override
    public SimplifiedUserResponse mapUserToSimplifiedUserResponse(User user) {
        return SimplifiedUserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
