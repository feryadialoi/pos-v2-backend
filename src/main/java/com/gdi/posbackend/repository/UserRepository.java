package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/4/2021 2:12 PM
 */
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    User findUserByUsername(String username);
}
