package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.SaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 9/2/2021 1:36 PM
 */
public interface SaleOrderRepository extends JpaRepository<SaleOrder, String>, JpaSpecificationExecutor<SaleOrder> {
}
