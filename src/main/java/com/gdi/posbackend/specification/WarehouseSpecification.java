package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Warehouse;
import org.springframework.data.jpa.domain.Specification;

import java.util.Locale;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:36 AM
 */
public class WarehouseSpecification {
    public static Specification<Warehouse> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.upper(root.get("name")),
                "%" + name.toUpperCase() + "%"
        );
    }

    public static Specification<Warehouse> addressIsLike(String address) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.upper(root.get("address")),
                "%" + address.toUpperCase() + "%"
        );
    }
}
