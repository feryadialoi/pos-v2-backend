package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Warehouse;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:36 AM
 */
public class WarehouseSpecification {
    public static Specification<Warehouse> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Warehouse> addressIsLike(String address) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("address"), "%" + address + "%"));
    }
}
