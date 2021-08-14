package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/13/2021 2:13 PM
 */
public interface BrandRepository extends JpaRepository<Brand, String>, JpaSpecificationExecutor<Brand> {

    Optional<Brand> findByName(String name);

}
