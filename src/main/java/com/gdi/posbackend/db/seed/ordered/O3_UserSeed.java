package com.gdi.posbackend.db.seed.ordered;

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
 * @date 8/4/2021 4:38 PM
 */
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class O3_UserSeed implements ApplicationListener<ApplicationReadyEvent>, Ordered {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Optional<User> optionalUser = userRepository.findByUsername("superadmin");
        if (optionalUser.isEmpty()) {
            seedUser();
        } else {
            log.info("no need to seed user data");
        }
    }

    private void seedUser() {
        Optional<Role> optionalRole = roleRepository.findByName("SUPER_ADMIN");
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();

            User user = new User();
            user.setName("Super Admin");
            user.setUsername("superadmin");
            user.setEmail("superadmin@app.com");
            user.setPassword(passwordEncoder.encode("password"));
            user.setRoles(List.of(role));

            userRepository.save(user);

            log.info("seed data user success");
        } else {
            log.info("role SUPER_ADMIN not found");
        }
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
