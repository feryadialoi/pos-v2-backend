package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.auth.Permission;
import com.gdi.posbackend.entity.auth.Role;
import com.gdi.posbackend.entity.auth.User;
import com.gdi.posbackend.mapper.UserMapper;
import com.gdi.posbackend.model.response.UserResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/7/2021 11:57 PM
 */
@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponse mapUserToUserResponse(User user) {
        List<Role> listOfRole = user.getRoles();

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
}
