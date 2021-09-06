package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.ProductStock;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 9/6/2021 3:03 PM
 */
public class ProductStockSpecification {

    public static Specification<ProductStock> productCodeIsLike(String productCode) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                root.get("product").get("code"),
                "%" + productCode + "%"
        );
    }

    public static Specification<ProductStock> productNameIsLike(String productName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                root.get("product").get("name"),
                "%" + productName + "%"
        );
    }

    public static Specification<ProductStock> warehouse(String warehouseId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.get("warehouse").get("id"),
                warehouseId
        );
    }

    public static Specification<ProductStock> productCategoryNameIsLike(String productCategoryName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                root.get("product").get("category").get("name"),
                "%" + productCategoryName + "%"
        );
    }
}
