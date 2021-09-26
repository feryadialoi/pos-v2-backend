package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Purchase;
import com.gdi.posbackend.entity.Purchase_;
import com.gdi.posbackend.entity.Supplier_;
import com.gdi.posbackend.entity.enums.PurchaseStatus;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

/**
 * @author Feryadialoi
 * @date 9/6/2021 9:06 PM
 */
public class PurchaseSpecification {
    public static Specification<Purchase> codeIsLike(String code) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Purchase_.code)),
                SpecificationUtil.like(code)
        );
    }

    public static Specification<Purchase> supplierNameIsLike(String supplierName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Purchase_.supplier).get(Supplier_.name)),
                SpecificationUtil.like(supplierName)
        );
    }

    public static Specification<Purchase> startDateGreaterThanOrEqual(LocalDate startDate) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(
                root.get(Purchase_.entryDate), startDate);
    }

    public static Specification<Purchase> endDateLessThanOrEqual(LocalDate endDate) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(
                root.get(Purchase_.entryDate), endDate);
    }

    public static Specification<Purchase> statusIs(PurchaseStatus status) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(Purchase_.status), status);
    }
}
