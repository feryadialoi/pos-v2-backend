package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Brand;
import com.gdi.posbackend.exception.BrandNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/13/2021 2:13 PM
 */
public interface BrandRepository extends JpaRepository<Brand, String>, JpaSpecificationExecutor<Brand> {

    Optional<Brand> findByName(String name);

    default Brand findByIdOrThrowNotFound(String brandId) {
        return findById(brandId).orElseThrow(() -> new BrandNotFoundException("brand with id " + brandId + " not found"));
    }

    @Query(value = "SELECT COUNT(*) as productCount FROM products WHERE products.brand_id = :brandId", nativeQuery = true)
    long productCountByBrandId(@Param("brandId") String brandId);
}
