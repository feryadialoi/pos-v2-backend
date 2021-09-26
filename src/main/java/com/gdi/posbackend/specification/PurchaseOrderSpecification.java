package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.PurchaseOrder;
import com.gdi.posbackend.entity.PurchaseOrder_;
import com.gdi.posbackend.entity.Supplier_;
import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/23/2021 3:16 PM
 */
public class PurchaseOrderSpecification {

    public static Specification<PurchaseOrder> statusIs(PurchaseOrderStatus status) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.get(PurchaseOrder_.status), status));
    }

    public static Specification<PurchaseOrder> supplierNameIsLike(String supplierName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(PurchaseOrder_.supplier).get(Supplier_.name)),
                SpecificationUtil.like(supplierName)
        );
    }

    public static Specification<PurchaseOrder> codeIsLike(String code) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(PurchaseOrder_.code)),
                SpecificationUtil.like(code)
        );
    }

    public static Specification<PurchaseOrder> startDateGreaterThanOrEqual(LocalDate startDate) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(
                root.get(PurchaseOrder_.entryDate), startDate);
    }

    public static Specification<PurchaseOrder> endDateLessThanOrEqual(LocalDate endDate) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(
                root.get(PurchaseOrder_.entryDate), endDate);
    }

    public static Specification<PurchaseOrder> statusesIn(List<PurchaseOrderStatus> statuses) {
        return (root, criteriaQuery, criteriaBuilder) -> root.get(PurchaseOrder_.status).in(statuses);
    }
}
