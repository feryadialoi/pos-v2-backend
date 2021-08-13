package com.gdi.posbackend.security;

import com.gdi.posbackend.entity.auth.Permission;
import com.gdi.posbackend.entity.auth.User;
import com.gdi.posbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Feryadialoi
 * @date 7/16/2021 11:05 AM
 */
@Slf4j
@Transactional
@Component
@AllArgsConstructor
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            return ApplicationUserDetails.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .authorities(getAuthorities(user))
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build();
        }
        throw new UsernameNotFoundException("user with username " + username + " not found");
    }

    private Collection<GrantedAuthority> getAuthorities(User user) {

//        Hibernate.initialize(user.getRoles());

        List<GrantedAuthority> grantedAuthorityRoles = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());

        List<GrantedAuthority> grantedAuthorityPermissions = user.getRoles()
                .stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(Permission::getName)
                .collect(Collectors.toSet())
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        log.info("roles         = {}", grantedAuthorityRoles);
        log.info("authorities   = {}", grantedAuthorityPermissions);

        return Stream.of(grantedAuthorityRoles, grantedAuthorityPermissions)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
