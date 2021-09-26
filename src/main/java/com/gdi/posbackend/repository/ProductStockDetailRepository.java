package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.entity.ProductStockDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/30/2021 12:51 AM
 */
public interface ProductStockDetailRepository extends JpaRepository<ProductStockDetail, String>, JpaSpecificationExecutor<ProductStockDetail> {

    @Query(value = "SELECT * FROM product_stock_details " +
                   "WHERE product_stock_id = :productStockId " +
                   "AND quantity > 0 " +
                   "ORDER BY created_by ASC LIMIT 1",
            nativeQuery = true)
    Optional<ProductStockDetail> findByProductStockIdAndQuantityGreaterThanZeroOrderByCreatedDateAsc(@Param("productStockId") String productStockId);

    @Query(value = "SELECT * FROM product_stock_details " +
                   "WHERE product_stock_id = :productStockId " +
                   "AND quantity > 0 " +
                   "ORDER BY created_by DESC LIMIT 1",
            nativeQuery = true)
    Optional<ProductStockDetail> findByProductStockIdAndQuantityGreaterThanZeroOrderByCreatedDateDesc(@Param("productStockId") String productStockId);
}
