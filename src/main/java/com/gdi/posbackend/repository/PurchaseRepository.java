package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Purchase;
import com.gdi.posbackend.entity.PurchaseOrder;
import com.gdi.posbackend.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 8/25/2021 1:50 AM
 */
public interface PurchaseRepository extends JpaRepository<Purchase, String>, JpaSpecificationExecutor<Purchase> {

    long countBySupplier(Supplier supplier);

    boolean existsByPurchaseOrder(PurchaseOrder purchaseOrder);

}
