package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.PurchaseReturnDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 9/21/2021 3:12 AM
 */
public interface PurchaseReturnDetailRepository extends JpaRepository<PurchaseReturnDetail, String>, JpaSpecificationExecutor<PurchaseReturnDetail> {
}
