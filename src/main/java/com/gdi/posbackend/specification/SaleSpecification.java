package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.entity.enums.SaleStatus;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import java.time.LocalDate;

/**
 * @author Feryadialoi
 * @date 9/15/2021 12:23 PM
 */
public class SaleSpecification {
    public static Specification<Sale> codeIsLike(String code) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Sale_.code)),
                SpecificationUtil.like(code)
        );
    }

    public static Specification<Sale> salesmanNameIsLike(String salesmanName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Sale_.salesman).get(Salesman_.name)),
                SpecificationUtil.like(salesmanName)
        );
    }

    public static Specification<Sale> customerNameIsLike(String customerName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Sale_.customer).get(Customer_.name)),
                SpecificationUtil.like(customerName)
        );
    }

    public static Specification<Sale> statusIs(SaleStatus status) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.get(Sale_.status), status);
    }

    public static Specification<Sale> startDateGreaterThanOrEqual(LocalDate startDate) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(
                root.get(Sale_.entryDate), startDate);
    }

    public static Specification<Sale> endDateLessThanOrEqual(LocalDate endDate) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(
                root.get(Sale_.entryDate), endDate);
    }

}
