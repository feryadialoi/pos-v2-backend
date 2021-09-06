package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.entity.ProductStockDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/30/2021 12:51 AM
 */
public interface ProductStockDetailRepository extends JpaRepository<ProductStockDetail, String>, JpaSpecificationExecutor<ProductStockDetail> {

    Optional<ProductStockDetail> findProductStockDetailByProductStockAndQuantityGreaterThanOrderByCreatedDateDesc(ProductStock productStock, BigDecimal quantity);

    Optional<ProductStockDetail> findProductStockDetailByProductStockAndQuantityGreaterThanOrderByCreatedDateAsc(ProductStock productStock, BigDecimal quantity);

}
