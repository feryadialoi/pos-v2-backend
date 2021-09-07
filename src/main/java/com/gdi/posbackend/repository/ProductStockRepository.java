package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.entity.Unit;
import com.gdi.posbackend.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/25/2021 4:25 AM
 */
public interface ProductStockRepository extends JpaRepository<ProductStock, String>, JpaSpecificationExecutor<ProductStock> {
    Optional<ProductStock> findProductStockByProductAndWarehouseAndUnit(Product product, Warehouse warehouse, Unit unit);

    Optional<ProductStock> findProductStockByWarehouseAndId(Warehouse warehouse, String id);
}
