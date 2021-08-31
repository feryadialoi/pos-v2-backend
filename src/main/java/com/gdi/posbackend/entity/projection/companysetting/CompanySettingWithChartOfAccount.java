package com.gdi.posbackend.entity.projection.companysetting;

import com.gdi.posbackend.entity.enums.CompanySettingCategory;
import com.gdi.posbackend.entity.enums.CompanySettingValueType;

/**
 * @author Feryadialoi
 * @date 8/26/2021 11:07 AM
 */
public interface CompanySettingWithChartOfAccount {
    String getId();

    String getChartOfAccountId();

    String getChartOfAccountName();

    Integer getChartOfAccountAccountCode();

    String getDisplayName();

    String getSettingName();

    String getSettingValue();

    CompanySettingValueType getSettingValueType();

    String getSettingDescription();

    CompanySettingCategory getCategory();
}
