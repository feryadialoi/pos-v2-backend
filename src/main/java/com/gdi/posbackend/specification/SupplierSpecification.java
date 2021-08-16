package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Supplier;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 8/16/2021 10:02 AM
 */
public class SupplierSpecification {
    public static Specification<Supplier> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Supplier> codeIsLike(String code) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("code"), "%" + code + "%");
    }

    public static Specification<Supplier> addressIsLike(String address) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("address"), "%" + address + "%");
    }

    public static Specification<Supplier> picIsLike(String pic) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("pic"), "%" + pic + "%");
    }

    public static Specification<Supplier> phoneIsLike(String phone) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("phone"), "%" + phone + "%");
    }

    public static Specification<Supplier> emailIsLike(String email) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("email"), "%" + email + "%");
    }

    public static Specification<Supplier> bankNameIsLike(String bankName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("bankName"), "%" + bankName + "%");
    }

    public static Specification<Supplier> bankBranchIsLike(String bankBranch) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("bankBranch"), "%" + bankBranch + "%");
    }

    public static Specification<Supplier> bankAccountNumberIsLike(String bankAccountNumber) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("bankAccountNumber"), "%" + bankAccountNumber + "%");
    }

    public static Specification<Supplier> taxableFirmNameIsLike(String taxableFirmName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("taxableFirmName"), "%" + taxableFirmName + "%");
    }

    public static Specification<Supplier> taxableFirmAddressIsLike(String taxableFirmAddress) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("taxableFirmAddress"), "%" + taxableFirmAddress + "%");
    }

    public static Specification<Supplier> taxIdentificationNumberIsLike(String taxIdentificationNumber) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("taxIdentificationNumber"), "%" + taxIdentificationNumber + "%");
    }


}
