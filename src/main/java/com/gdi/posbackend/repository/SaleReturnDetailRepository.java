package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.SaleReturnDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 9/21/2021 3:13 AM
 */
public interface SaleReturnDetailRepository extends JpaRepository<SaleReturnDetail, String>, JpaSpecificationExecutor<SaleReturnDetail> {
}
