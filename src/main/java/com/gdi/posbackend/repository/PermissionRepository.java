package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.auth.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/4/2021 2:15 PM
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    List<Permission> findAllByNameIn(List<String> names);
}
