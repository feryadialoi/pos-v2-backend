package com.gdi.posbackend.db.seed;

import com.gdi.posbackend.entity.auth.Role;
import com.gdi.posbackend.entity.auth.User;
import com.gdi.posbackend.repository.RoleRepository;
import com.gdi.posbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/4/2021 4:44 PM
 */
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class SeedUserAndRole {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    public void seed() {
        Optional<User> optionalUser = userRepository.findByUsername("superadmin");
        Optional<Role> optionalRole = roleRepository.findByName("SUPER_ADMIN");

        if (optionalUser.isPresent() && optionalRole.isPresent()) {
            log.info("no need to seed user & role data");
        } else {
            seedRoleAndUser();
        }
    }


    private void seedRoleAndUser() {
        Role role = createRole();
        createUser(role);
    }

    private void createUser(Role role) {
        User user = new User();
        user.setName("Super Admin");
        user.setUsername("superadmin");
        user.setEmail("superadmin@app.com");
        user.setPassword(passwordEncoder.encode("password"));
        user.setRoles(List.of(role));

        userRepository.save(user);
        log.info("seed data user success");
    }

    private Role createRole() {
        Role role = new Role();
        role.setName("SUPER_ADMIN");
        role.setDescription("Super admin");
        role.setDisplayName("Super Admin");

        role = roleRepository.save(role);
        log.info("seed data role success");
        return role;
    }
}
