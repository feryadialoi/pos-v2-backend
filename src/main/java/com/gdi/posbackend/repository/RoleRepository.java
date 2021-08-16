package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/4/2021 2:14 PM
 */
public interface RoleRepository extends JpaRepository<Role, String>, JpaSpecificationExecutor<Role> {
    Optional<Role> findByName(String name);
}
