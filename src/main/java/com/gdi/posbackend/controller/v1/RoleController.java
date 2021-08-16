package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.criteria.RoleCriteria;
import com.gdi.posbackend.model.request.CreateRoleRequest;
import com.gdi.posbackend.model.request.UpdateRoleRequest;
import com.gdi.posbackend.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 8/15/2021 11:21 PM
 */
@RestController
@RequestMapping("/api/v1/roles")
@AllArgsConstructor
public class RoleController extends BaseController {

    private final RoleService roleService;

    @GetMapping
    public Object getRoles(RoleCriteria roleCriteria, Pageable pageable) {
        return response("get roles success", roleService.getRoles(roleCriteria, pageable));
    }

    @PostMapping
    public Object createRole(@Valid @RequestBody CreateRoleRequest createRoleRequest) {
        return response("create role success", roleService.createRole(createRoleRequest));
    }

    @PutMapping("/{roleId}")
    public Object updateRole(@PathVariable(name = "roleId") String roleId, UpdateRoleRequest updateRoleRequest) {
        return response("update role success", roleService.updateRole(roleId, updateRoleRequest));
    }
}
