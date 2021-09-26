package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.auth.User;
import com.gdi.posbackend.exception.UserNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/4/2021 2:12 PM
 */
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
    Optional<User> findByUsername(String username);

    boolean existsByEmail(String email);

    User findUserByUsername(String username);

    default User findByIdOrThrowNotFound(String userId) {
        return findById(userId).orElseThrow(() -> new UserNotFoundException("user with id " + userId + " not found"));
    }

    boolean existsByUsername(String username);
}
