package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Category;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 8/5/2021 9:45 AM
 */
public class CategorySpecification {
    public static Specification<Category> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }
}
