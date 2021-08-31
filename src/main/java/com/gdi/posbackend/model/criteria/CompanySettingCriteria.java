package com.gdi.posbackend.model.criteria;

import com.gdi.posbackend.entity.enums.CompanySettingCategory;
import lombok.Data;

/**
 * @author Feryadialoi
 * @date 8/25/2021 10:00 AM
 */
@Data
public class CompanySettingCriteria {
    private String settingName;
    private CompanySettingCategory category;
}
