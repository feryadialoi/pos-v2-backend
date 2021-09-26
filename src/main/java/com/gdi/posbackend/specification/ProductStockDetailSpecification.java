package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.ProductStockDetail;
import com.gdi.posbackend.entity.ProductStockDetail_;
import com.gdi.posbackend.entity.ProductStock_;
import com.gdi.posbackend.entity.Product_;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 9/17/2021 11:07 AM
 */
public class ProductStockDetailSpecification {
    public static Specification<ProductStockDetail> productStockIdIs(String productStockId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.get(ProductStockDetail_.productStock).get(ProductStock_.id),
                productStockId
        );
    }

    public static Specification<ProductStockDetail> quantityGreaterThan(BigDecimal quantity) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(
                root.get(ProductStockDetail_.quantity),
                quantity
        );
    }

    public static Specification<ProductStockDetail> productNameIsLike(String productName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(ProductStockDetail_.productStock).get(ProductStock_.product).get(Product_.name)),
                SpecificationUtil.like(productName)
        );
    }


    public static Specification<ProductStockDetail> batchIsLike(String batch) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(ProductStockDetail_.batch)),
                SpecificationUtil.like(batch)
        );
    }


    public static Specification<ProductStockDetail> quantityIs(BigDecimal quantity) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.get(ProductStockDetail_.quantity),
                quantity
        );
    }


    public static Specification<ProductStockDetail> quantityGe(BigDecimal quantity) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(
                root.get(ProductStockDetail_.quantity),
                quantity
        );
    }

    public static Specification<ProductStockDetail> quantityGt(BigDecimal quantity) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(
                root.get(ProductStockDetail_.quantity),
                quantity
        );
    }

    public static Specification<ProductStockDetail> quantityLe(BigDecimal quantity) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(
                root.get(ProductStockDetail_.quantity),
                quantity
        );
    }

    public static Specification<ProductStockDetail> quantityLt(BigDecimal quantity) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThan(
                root.get(ProductStockDetail_.quantity),
                quantity
        );
    }
}
