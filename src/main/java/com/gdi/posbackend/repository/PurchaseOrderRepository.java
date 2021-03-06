package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.PurchaseOrder;
import com.gdi.posbackend.entity.Supplier;
import com.gdi.posbackend.exception.PurchaseOrderNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 8/23/2021 10:24 AM
 */
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, String>, JpaSpecificationExecutor<PurchaseOrder> {
    default PurchaseOrder findPurchaseOrderByIdOrThrowNotFound(String purchaseOrderId) {
        return findById(purchaseOrderId).orElseThrow(() -> new PurchaseOrderNotFoundException("purchase order with id " + purchaseOrderId + " not found"));
    }

    long countBySupplier(Supplier supplier);
}