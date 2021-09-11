package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.exception.WarehouseNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Feryadialoi
 * @date 8/5/2021 12:05 AM
 */
public interface WarehouseRepository extends JpaRepository<Warehouse, String>, JpaSpecificationExecutor<Warehouse> {
    default Warehouse findByIdOrThrowNotFound(String warehouseId) {
        return findById(warehouseId).orElseThrow(() -> new WarehouseNotFoundException("warehouse with id " + warehouseId + " not found"));
    }

    @Query(value = "SELECT COUNT(*) FROM product_stocks WHERE product_stocks.warehouse_id = :warehouseId", nativeQuery = true)
    long productStockCountByWarehouseId(@Param("warehouseId") String warehouseId);
}
