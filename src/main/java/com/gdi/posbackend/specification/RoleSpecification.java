package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.auth.Role;
import com.gdi.posbackend.entity.auth.Role_;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 8/15/2021 11:38 PM
 */
public class RoleSpecification {
    public static Specification<Role> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Role_.name)),
                SpecificationUtil.like(name)
        );
    }
}
