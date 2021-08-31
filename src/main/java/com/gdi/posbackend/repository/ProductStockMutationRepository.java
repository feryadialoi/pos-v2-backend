package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.ProductStockMutation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 8/25/2021 4:27 AM
 */
public interface ProductStockMutationRepository extends JpaRepository<ProductStockMutation, String>, JpaSpecificationExecutor<ProductStockMutation> {
}
