package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Unit;
import com.gdi.posbackend.exception.UnitNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:16 AM
 */
public interface UnitRepository extends JpaRepository<Unit, String>, JpaSpecificationExecutor<Unit> {
    Optional<Unit> findByNameLike(String name);

    Optional<Unit> findByNameIgnoreCase(String name);

    long countByNameInIgnoreCase(List<String> names);

    default Unit findByIdOrThrowNotFound(String unitId) {
        return findById(unitId).orElseThrow(() -> new UnitNotFoundException("unit with id " + unitId + " not found"));
    }

    @Query(value = "SELECT COUNT(*) FROM products_units WHERE unit_id = :brandId", nativeQuery = true)
    long productCountByBrandId(@Param("brandId") String brandId);
}
