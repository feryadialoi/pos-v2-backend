package com.gdi.posbackend.db.seed.ordered;

import com.gdi.posbackend.entity.auth.Permission;
import com.gdi.posbackend.entity.auth.Role;
import com.gdi.posbackend.repository.PermissionRepository;
import com.gdi.posbackend.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 7/30/2021 10:02 AM
 */
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class O4_RoleWithPermissionSeed implements ApplicationListener<ApplicationReadyEvent>, Ordered {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        long count = roleRepository.count();
        if (count == 0) {
            seedRoleSuperAdmin();
            seedRoleAdmin();
            seedRoleStaff();
            log.info("seed roles success");
        } else {
            log.info("no need to seed roles");
        }
    }

    private void seedRoleSuperAdmin() {
        List<Permission> permissions = permissionRepository.findAllByNameIn(Arrays.asList(
                "CREATE_COMPANY", "GET_COMPANIES", "GET_COMPANY", "UPDATE_COMPANY", "DELETE_COMPANY"
        ));
        Role role = new Role("SUPER_ADMIN", "Super Admin", "Super Admin", permissions);
        roleRepository.save(role);
    }

    private void seedRoleAdmin() {
        List<Permission> permissions = permissionRepository.findAllByNameIn(Arrays.asList(
                "CREATE_COMPANY", "GET_COMPANIES", "GET_COMPANY", "UPDATE_COMPANY"
        ));
        Role role = new Role("ADMIN", "Admin", "Admin", permissions);
        roleRepository.save(role);
    }

    private void seedRoleStaff() {
        List<Permission> permissions = permissionRepository.findAllByNameIn(Arrays.asList(
                "CREATE_COMPANY", "GET_COMPANIES", "GET_COMPANY", "UPDATE_COMPANY"
        ));
        Role role = new Role("STAFF", "Staff", "Staff", permissions);
        roleRepository.save(role);
    }

    @Override
    public int getOrder() {
        return 4;
    }
}
