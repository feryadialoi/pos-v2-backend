package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.CompanySetting;
import com.gdi.posbackend.entity.projection.companysetting.CompanySettingWithChartOfAccount;
import com.gdi.posbackend.model.response.CompanySettingResponse;
import com.gdi.posbackend.model.response.CompanySettingWithChartOfAccountResponse;

/**
 * @author Feryadialoi
 * @date 8/25/2021 10:07 AM
 */
public interface CompanySettingMapper {
    CompanySettingResponse mapCompanySettingToCompanySettingResponse(CompanySetting companySetting);

    CompanySettingWithChartOfAccountResponse mapCompanySettingWithChartOfAccountToCompanySettingWithChartOfAccountResponse(CompanySettingWithChartOfAccount companySettingWithChartOfAccount);
}
