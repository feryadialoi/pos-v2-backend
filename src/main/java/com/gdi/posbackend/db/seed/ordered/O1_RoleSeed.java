package com.gdi.posbackend.db.seed.ordered;

import com.gdi.posbackend.entity.auth.Role;
import com.gdi.posbackend.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/4/2021 4:44 PM
 */
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class O1_RoleSeed implements ApplicationListener<ApplicationReadyEvent>, Ordered {

    private final RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Optional<Role> optionalRole = roleRepository.findByName("SUPER_ADMIN");
        if (optionalRole.isEmpty()) {
            seedRole();
        } else {
            log.info("no need to seed role data");
        }

    }

    private void seedRole() {
        Role role = new Role();
        role.setName("SUPER_ADMIN");
        role.setDescription("super admin");
        role.setDisplayName("Super Admin");

        roleRepository.save(role);
        log.info("seed data role success");
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
