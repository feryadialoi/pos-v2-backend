package com.gdi.posbackend.service;

import com.gdi.posbackend.model.criteria.RoleCriteria;
import com.gdi.posbackend.model.request.CreateRoleRequest;
import com.gdi.posbackend.model.request.UpdateRoleRequest;
import com.gdi.posbackend.model.response.DetailedRoleResponse;
import com.gdi.posbackend.model.response.RoleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/15/2021 11:23 PM
 */
public interface RoleService {

    Page<RoleResponse> getRoles(RoleCriteria roleCriteria, Pageable pageable);

    DetailedRoleResponse getRole(String roleId);

    DetailedRoleResponse createRole(CreateRoleRequest createRoleRequest);

    DetailedRoleResponse updateRole(String roleId, UpdateRoleRequest updateRoleRequest);

    Object deleteRole(String roleId);

}
