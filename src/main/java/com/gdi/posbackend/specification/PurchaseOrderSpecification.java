package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.PurchaseOrder;
import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import com.gdi.posbackend.util.LocalDateUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/23/2021 3:16 PM
 */
public class PurchaseOrderSpecification {

    public static Specification<PurchaseOrder> statusIs(PurchaseOrderStatus status) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status));
    }

    public static Specification<PurchaseOrder> supplierNameIsLike(String supplierName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("supplier").get("name"), "%" + supplierName + "%");
    }

    public static Specification<PurchaseOrder> codeIsLike(String code) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("code"), "%" + code + "%");
    }

    public static Specification<PurchaseOrder> startDateGreaterThanOrEqual(String startDate) {
        LocalDateUtil localDateUtil = new LocalDateUtil();
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("entryDate"), localDateUtil.fromString(startDate));
    }

    public static Specification<PurchaseOrder> endDateLessThanOrEqual(String endDate) {
        LocalDateUtil localDateUtil = new LocalDateUtil();
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("entryDate"), localDateUtil.fromString(endDate));
    }

    public static Specification<PurchaseOrder> statusesIn(List<PurchaseOrderStatus> statuses) {
        return (root, criteriaQuery, criteriaBuilder) -> root.get("status").in(statuses);
    }
}
