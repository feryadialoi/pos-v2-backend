package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.auth.Role;
import com.gdi.posbackend.exception.RoleNotFoundException;
import com.gdi.posbackend.mapper.RoleMapper;
import com.gdi.posbackend.model.criteria.RoleCriteria;
import com.gdi.posbackend.model.request.CreateRoleRequest;
import com.gdi.posbackend.model.request.UpdateRoleRequest;
import com.gdi.posbackend.model.response.DetailedRoleResponse;
import com.gdi.posbackend.model.response.RoleResponse;
import com.gdi.posbackend.repository.PermissionRepository;
import com.gdi.posbackend.repository.RoleRepository;
import com.gdi.posbackend.service.RoleService;
import com.gdi.posbackend.specification.RoleSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


/**
 * @author Feryadialoi
 * @date 8/15/2021 11:31 PM
 */
@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final RoleMapper roleMapper;

    @Override
    public Page<RoleResponse> getRoles(RoleCriteria roleCriteria, Pageable pageable) {
        Specification<Role> specification = Specification.where(null);

        if (roleCriteria.getName() != null) {
            specification = specification.and(RoleSpecification.nameIsLike(roleCriteria.getName()));
        }

        return roleRepository
                .findAll(specification, pageable)
                .map(roleMapper::mapRoleToRoleResponse);
    }

    @Override
    public DetailedRoleResponse getRole(String roleId) {
        return roleRepository
                .findById(roleId)
                .map(roleMapper::mapRoleToDetailedRoleResponse)
                .orElseThrow(() -> new RoleNotFoundException("role with id " + roleId + " not found"));
    }

    @Override
    public DetailedRoleResponse createRole(CreateRoleRequest createRoleRequest) {
        Role role = new Role();
        role.setDisplayName(createRoleRequest.getDisplayName());
        role.setDescription(createRoleRequest.getDescription());
        role = roleRepository.save(role);
        return roleMapper.mapRoleToDetailedRoleResponse(role);
    }

    @Override
    public DetailedRoleResponse updateRole(String roleId, UpdateRoleRequest updateRoleRequest) {
        return null;
    }

    @Override
    public Object deleteRole(String roleId) {
        return null;
    }
}
