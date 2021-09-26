package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Customer_;
import com.gdi.posbackend.entity.SaleOrder;
import com.gdi.posbackend.entity.SaleOrder_;
import com.gdi.posbackend.entity.Salesman_;
import com.gdi.posbackend.entity.enums.SaleOrderStatus;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/15/2021 11:26 AM
 */
public class SaleOrderSpecification {
    public static Specification<SaleOrder> statusIs(SaleOrderStatus status) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.get(SaleOrder_.status), status);
    }

    public static Specification<SaleOrder> salesmanNameIsLike(String salesmanName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(SaleOrder_.salesman).get(Salesman_.name)),
                SpecificationUtil.like(salesmanName)
        );
    }

    public static Specification<SaleOrder> customerNameIsLike(String customerName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(SaleOrder_.customer).get(Customer_.name)),
                SpecificationUtil.like(customerName)
        );
    }

    public static Specification<SaleOrder> codeIsLike(String code) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(SaleOrder_.code)),
                SpecificationUtil.like(code)
        );
    }

    public static Specification<SaleOrder> startDateGreaterThanOrEqual(LocalDate startDate) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(
                root.get(SaleOrder_.entryDate), startDate);
    }

    public static Specification<SaleOrder> endDateLessThanOrEqual(LocalDate endDate) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(
                root.get(SaleOrder_.entryDate), endDate);
    }

    public static Specification<SaleOrder> statusesIn(List<SaleOrderStatus> statuses) {
        return (root, criteriaQuery, criteriaBuilder) -> root.get(SaleOrder_.status).in(statuses);
    }


}
