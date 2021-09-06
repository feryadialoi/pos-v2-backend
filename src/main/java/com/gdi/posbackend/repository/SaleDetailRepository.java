package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 9/3/2021 9:23 AM
 */
public interface SaleDetailRepository extends JpaRepository<SaleDetail, String>, JpaSpecificationExecutor<SaleDetail> {
}
