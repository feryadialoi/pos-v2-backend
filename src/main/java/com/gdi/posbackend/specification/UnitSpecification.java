package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Unit;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:18 AM
 */
public class UnitSpecification {
    public static Specification<Unit> nameIsLike(String name) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%"));
    }
}
