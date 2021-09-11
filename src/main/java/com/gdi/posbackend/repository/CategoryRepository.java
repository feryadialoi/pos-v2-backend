package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/5/2021 9:43 AM
 */
public interface CategoryRepository extends JpaRepository<Category, String>, JpaSpecificationExecutor<Category> {
    Optional<Category> findByName(String name);

    @Query(value = "SELECT COUNT(*) FROM products WHERE products.category_id = :categoryId", nativeQuery = true)
    long productCountByCategoryId(@Param("categoryId") String categoryId);

     
}
