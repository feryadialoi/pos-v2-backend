package com.gdi.posbackend.model.response;

import com.gdi.posbackend.entity.enums.CompanySettingCategory;
import com.gdi.posbackend.entity.enums.CompanySettingValueType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/26/2021 11:38 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanySettingWithChartOfAccountResponse {

    private String id;

    private ChartOfAccountOfCompanySettingWithChartOfAccountResponse chartOfAccount;

    private String displayName;

    private String settingName;

    private String settingValue;

    private CompanySettingValueType settingValueType;

    private String settingDescription;

    private CompanySettingCategory category;
}
