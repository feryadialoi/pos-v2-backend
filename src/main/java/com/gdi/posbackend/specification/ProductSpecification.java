package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.Brand_;
import com.gdi.posbackend.entity.Category_;
import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.entity.Product_;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:39 AM
 */
public class ProductSpecification {

    public static Specification<Product> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Product_.name)),
                SpecificationUtil.like(name)
        );
    }

    public static Specification<Product> codeIsLike(String code) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Product_.code)),
                SpecificationUtil.like(code)
        );
    }

    public static Specification<Product> categoryNameIsLike(String categoryName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Product_.category).get(Category_.name)),
                SpecificationUtil.like(categoryName)
        );
    }

    public static Specification<Product> brandNameIsLike(String brandName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Product_.brand).get(Brand_.name)),
                SpecificationUtil.like(brandName)
        );
    }

}