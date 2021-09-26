package com.gdi.posbackend.specification;

import com.gdi.posbackend.entity.CompanySetting;
import com.gdi.posbackend.entity.CompanySetting_;
import com.gdi.posbackend.entity.enums.CompanySettingCategory;
import com.gdi.posbackend.util.SpecificationUtil;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Feryadialoi
 * @date 8/25/2021 10:11 AM
 */
public class CompanySettingSpecification {
    public static Specification<CompanySetting> settingNameIsLike(String settingName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(CompanySetting_.settingName)),
                SpecificationUtil.like(settingName)
        );
    }

    public static Specification<CompanySetting> categoryIs(CompanySettingCategory category) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                root.get(CompanySetting_.category), category);
    }
}
