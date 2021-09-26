package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Company_;
import com.gdi.posbackend.entity.Salesman;
import com.gdi.posbackend.entity.Salesman_;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 9/14/2021 4:11 PM
 */
public class SalesmanSpecification {
    public static Specification<Salesman> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Salesman_.name)),
                SpecificationUtil.like(name)
        );
    }

    public static Specification<Salesman> addressIsLike(String address) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Salesman_.address)),
                SpecificationUtil.like(address)
        );
    }

    public static Specification<Salesman> phoneIsLike(String phone) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Salesman_.phone)),
                SpecificationUtil.like(phone)
        );
    }

    public static Specification<Salesman> companyNameIsLike(String companyName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Salesman_.company).get(Company_.name)),
                SpecificationUtil.like(companyName)
        );
    }


}
