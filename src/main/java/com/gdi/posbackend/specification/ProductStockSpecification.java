package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 9/6/2021 3:03 PM
 */
public class ProductStockSpecification {

    public static Specification<ProductStock> productCodeIsLike(String productCode) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(ProductStock_.product).get(Product_.code)),
                SpecificationUtil.like(productCode)
        );
    }

    public static Specification<ProductStock> productNameIsLike(String productName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(ProductStock_.product).get(Product_.name)),
                SpecificationUtil.like(productName)
        );
    }

    public static Specification<ProductStock> warehouseIdIs(String warehouseId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.get(ProductStock_.warehouse).get(Warehouse_.id), warehouseId);
    }

    public static Specification<ProductStock> productCategoryNameIsLike(String productCategoryName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(ProductStock_.product).get(Product_.category).get(Category_.name)),
                SpecificationUtil.like(productCategoryName)
        );
    }

    public static Specification<ProductStock> productIdIs(String productId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(ProductStock_.product).get(Product_.id), productId);
    }

    public static Specification<ProductStock> idIs(String id) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(ProductStock_.id), id);
    }

    public static Specification<ProductStock> stockIs(BigDecimal stock) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(ProductStock_.stock), stock);
    }

    public static Specification<ProductStock> stockGe(BigDecimal stock) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(ProductStock_.stock), stock);
    }

    public static Specification<ProductStock> stockGt(BigDecimal stock) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(ProductStock_.stock), stock);
    }

    public static Specification<ProductStock> stockLe(BigDecimal stock) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(ProductStock_.stock), stock);
    }

    public static Specification<ProductStock> stockLt(BigDecimal stock) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThan(root.get(ProductStock_.stock), stock);
    }
}
