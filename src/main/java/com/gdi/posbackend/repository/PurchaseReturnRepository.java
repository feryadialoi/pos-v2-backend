package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.PurchaseReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 9/21/2021 2:51 AM
 */
public interface PurchaseReturnRepository extends JpaRepository<PurchaseReturn, String>, JpaSpecificationExecutor<PurchaseReturn> {
}
