package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.CompanySetting;
import com.gdi.posbackend.entity.projection.companysetting.CompanySettingWithChartOfAccount;
import com.gdi.posbackend.mapper.CompanySettingMapper;
import com.gdi.posbackend.model.response.ChartOfAccountOfCompanySettingWithChartOfAccountResponse;
import com.gdi.posbackend.model.response.CompanySettingResponse;
import com.gdi.posbackend.model.response.CompanySettingWithChartOfAccountResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/25/2021 10:08 AM
 */
@Component
@AllArgsConstructor
public class CompanySettingMapperImpl implements CompanySettingMapper {


    @Override
    public CompanySettingResponse mapCompanySettingToCompanySettingResponse(CompanySetting companySetting) {
        return CompanySettingResponse.builder()
                .id(companySetting.getId())
                .displayName(companySetting.getDisplayName())
                .settingName(companySetting.getSettingName())
                .settingValueType(companySetting.getSettingValueType())
                .settingValue(companySetting.getSettingValue())
                .category(companySetting.getCategory())
                .settingDescription(companySetting.getSettingDescription())
                .build();
    }

    @Override
    public CompanySettingWithChartOfAccountResponse mapCompanySettingWithChartOfAccountToCompanySettingWithChartOfAccountResponse(CompanySettingWithChartOfAccount companySettingWithChartOfAccount) {
        return CompanySettingWithChartOfAccountResponse.builder()
                .id(companySettingWithChartOfAccount.getId())
                .chartOfAccount(
                        companySettingWithChartOfAccount.getSettingValue() == null
                                ? null :
                                ChartOfAccountOfCompanySettingWithChartOfAccountResponse.builder()
                                        .id(companySettingWithChartOfAccount.getChartOfAccountId())
                                        .name(companySettingWithChartOfAccount.getChartOfAccountName())
                                        .accountCode(companySettingWithChartOfAccount.getChartOfAccountAccountCode())
                                        .build())
                .category(companySettingWithChartOfAccount.getCategory())
                .displayName(companySettingWithChartOfAccount.getDisplayName())
                .settingName(companySettingWithChartOfAccount.getSettingName())
                .settingValue(companySettingWithChartOfAccount.getSettingValue())
                .settingDescription(companySettingWithChartOfAccount.getSettingDescription())
                .settingValueType(companySettingWithChartOfAccount.getSettingValueType())
                .build();
    }
}
