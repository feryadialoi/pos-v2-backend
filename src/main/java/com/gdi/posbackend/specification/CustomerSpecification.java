package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Company_;
import com.gdi.posbackend.entity.Customer;
import com.gdi.posbackend.entity.Customer_;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 9/14/2021 12:20 PM
 */
public class CustomerSpecification {
    public static Specification<Customer> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Customer_.name)),
                SpecificationUtil.like(name)
        );
    }

    public static Specification<Customer> nationalIdentificationNumberIsLike(String nationalIdentificationNumber) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Customer_.nationalIdentificationNumber)),
                SpecificationUtil.like(nationalIdentificationNumber)
        );
    }

    public static Specification<Customer> addressIsLike(String address) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Customer_.address)),
                SpecificationUtil.like(address)
        );
    }

    public static Specification<Customer> phoneIsLike(String phone) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Customer_.phone)),
                SpecificationUtil.like(phone)
        );
    }

    public static Specification<Customer> phone2IsLike(String phone2) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Customer_.phone2)),
                SpecificationUtil.like(phone2)
        );
    }

    public static Specification<Customer> descriptionIsLike(String description) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Customer_.description)),
                SpecificationUtil.like(description)
        );
    }

}
