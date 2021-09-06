package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 9/3/2021 9:22 AM
 */
public interface SaleRepository extends JpaRepository<Sale, String>, JpaSpecificationExecutor<String> {
}
