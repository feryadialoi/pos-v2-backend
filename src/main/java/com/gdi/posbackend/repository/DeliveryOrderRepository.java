package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 9/21/2021 3:18 AM
 */
public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, String>, JpaSpecificationExecutor<DeliveryOrder> {
}
