package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Company;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 8/30/2021 10:48 AM
 */
public class CompanySpecification {
    public static Specification<Company> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }
}
