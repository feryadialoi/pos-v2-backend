package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/5/2021 9:43 AM
 */
public interface CategoryRepository extends JpaRepository<Category, String>, JpaSpecificationExecutor<Category> {
    Optional<Category> findByName(String name);
}
