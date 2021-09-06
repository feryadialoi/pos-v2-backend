package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Purchase;
import com.gdi.posbackend.entity.enums.PurchaseStatus;
import com.gdi.posbackend.util.LocalDateUtil;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 9/6/2021 9:06 PM
 */
public class PurchaseSpecification {
    public static Specification<Purchase> codeIsLike(String code) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                root.get("code"),
                "%" + code + "%"
        );
    }

    public static Specification<Purchase> supplierNameIsLike(String supplierName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                root.get("supplier").get("name"),
                "%" + supplierName + "%"
        );
    }

    public static Specification<Purchase> startDateGreaterThanOrEqual(String startDate) {
        LocalDateUtil localDateUtil = new LocalDateUtil();
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(
                root.get("entryDate"),
                localDateUtil.fromString(startDate)
        );
    }

    public static Specification<Purchase> endDateLessThanOrEqual(String endDate) {
        LocalDateUtil localDateUtil = new LocalDateUtil();
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(
                root.get("entryDate"),
                localDateUtil.fromString(endDate)
        );
    }

    public static Specification<Purchase> statusIs(PurchaseStatus status) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
    }
}
