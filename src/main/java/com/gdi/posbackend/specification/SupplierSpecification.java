package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Supplier;
import com.gdi.posbackend.entity.Supplier_;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Locale;

/**
 * @author Feryadialoi
 * @date 8/16/2021 10:02 AM
 */
public class SupplierSpecification {

    public static Specification<Supplier> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Supplier_.name)),
                SpecificationUtil.like(name)
        );
    }

    public static Specification<Supplier> codeIsLike(String code) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Supplier_.code)),
                SpecificationUtil.like(code)
        );
    }

    public static Specification<Supplier> addressIsLike(String address) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Supplier_.address)),
                SpecificationUtil.like(address)
        );
    }

    public static Specification<Supplier> picIsLike(String pic) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Supplier_.pic)),
                SpecificationUtil.like(pic)
        );
    }

    public static Specification<Supplier> phoneIsLike(String phone) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Supplier_.phone)),
                SpecificationUtil.like(phone)
        );
    }

    public static Specification<Supplier> emailIsLike(String email) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Supplier_.email)),
                SpecificationUtil.like(email)
        );
    }

    public static Specification<Supplier> bankNameIsLike(String bankName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Supplier_.bankName)),
                SpecificationUtil.like(bankName)
        );
    }

    public static Specification<Supplier> bankBranchIsLike(String bankBranch) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Supplier_.bankBranch)),
                SpecificationUtil.like(bankBranch)
        );
    }

    public static Specification<Supplier> bankAccountNumberIsLike(String bankAccountNumber) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Supplier_.bankAccountNumber)),
                SpecificationUtil.like(bankAccountNumber)
        );
    }

    public static Specification<Supplier> taxableFirmNameIsLike(String taxableFirmName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Supplier_.taxableFirmName)),
                SpecificationUtil.like(taxableFirmName)
        );
    }

    public static Specification<Supplier> taxableFirmAddressIsLike(String taxableFirmAddress) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Supplier_.taxableFirmAddress)),
                SpecificationUtil.like(taxableFirmAddress)
        );
    }

    public static Specification<Supplier> taxIdentificationNumberIsLike(String taxIdentificationNumber) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Supplier_.taxIdentificationNumber)),
                SpecificationUtil.like(taxIdentificationNumber)
        );
    }


}
