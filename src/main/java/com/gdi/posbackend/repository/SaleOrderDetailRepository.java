package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.SaleOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 9/2/2021 1:41 PM
 */
public interface SaleOrderDetailRepository extends JpaRepository<SaleOrderDetail, String>, JpaSpecificationExecutor<SaleOrderDetail> {
}
