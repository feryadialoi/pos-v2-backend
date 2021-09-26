package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.entity.Warehouse_;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

import java.util.Locale;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:36 AM
 */
public class WarehouseSpecification {
    public static Specification<Warehouse> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Warehouse_.name)),
                SpecificationUtil.like(name)
        );
    }

    public static Specification<Warehouse> addressIsLike(String address) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Warehouse_.address)),
                SpecificationUtil.like(address)
        );
    }
}
