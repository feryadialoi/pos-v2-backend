package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Product;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:39 AM
 */
public class ProductSpecification {

    public static Specification<Product> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                root.get("name"),
                "%" + name + "%"
        );
    }

    public static Specification<Product> codeIsLike(String code) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                root.get("code"),
                "%" + code + "%"
        );
    }

    public static Specification<Product> categoryNameIsLike(String categoryName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                root.get("category").get("name"),
                "%" + categoryName + "%"
        );
    }

    public static Specification<Product> brandNameIsLike(String brandName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                root.get("brand").get("name"),
                "%" + brandName + "%"
        );
    }

}