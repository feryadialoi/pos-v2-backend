package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.DeliveryOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 9/21/2021 3:19 AM
 */
public interface DeliveryOrderDetailRepository extends JpaRepository<DeliveryOrderDetail, String>, JpaSpecificationExecutor<DeliveryOrderDetail> {
}
