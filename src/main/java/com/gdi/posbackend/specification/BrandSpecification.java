package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Brand;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 8/13/2021 2:17 PM
 */
public class BrandSpecification {
    public static Specification<Brand> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + name.toUpperCase() + "%");
    }
}
