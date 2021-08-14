package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

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

}
