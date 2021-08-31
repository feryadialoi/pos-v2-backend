package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.PurchaseOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Feryadialoi
 * @date 8/23/2021 10:24 AM
 */
public interface PurchaseOrderDetailRepository extends JpaRepository<PurchaseOrderDetail, String> {
}
