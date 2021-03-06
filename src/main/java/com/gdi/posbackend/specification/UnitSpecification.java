package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Unit;
import com.gdi.posbackend.entity.Unit_;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:18 AM
 */
public class UnitSpecification {
    public static Specification<Unit> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Unit_.name)),
                SpecificationUtil.like(name)
        );
    }
}
