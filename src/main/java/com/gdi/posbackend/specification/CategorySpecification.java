package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Category;
import com.gdi.posbackend.entity.Category_;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 8/5/2021 9:45 AM
 */
public class CategorySpecification {
    public static Specification<Category> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Category_.name)),
                SpecificationUtil.like(name)
        );
    }
}
