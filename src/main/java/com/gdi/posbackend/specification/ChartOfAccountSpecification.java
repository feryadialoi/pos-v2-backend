package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.ChartOfAccount;
import com.gdi.posbackend.entity.ChartOfAccount_;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author Feryadialoi
 * @date 8/19/2021 11:32 PM
 */
public class ChartOfAccountSpecification {

    public static Specification<ChartOfAccount> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(ChartOfAccount_.name)),
                SpecificationUtil.like(name)
        );
    }

}
