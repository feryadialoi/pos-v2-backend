package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.UnitConversion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Feryadialoi
 * @date 8/5/2021 1:49 PM
 */
public interface UnitConversionRepository extends JpaRepository<UnitConversion, String> {
}
