package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.CompanySetting;
import com.gdi.posbackend.model.criteria.CompanySettingCriteria;
import com.gdi.posbackend.model.request.CreateCompanySettingRequest;
import com.gdi.posbackend.model.request.UpdateCompanyRequestWithChartOfAccountRequest;
import com.gdi.posbackend.model.request.UpdateCompanySettingRequest;
import com.gdi.posbackend.model.response.CompanySettingResponse;
import com.gdi.posbackend.model.response.CompanySettingWithChartOfAccountResponse;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/25/2021 10:03 AM
 */
public interface CompanySettingService {
    List<CompanySettingResponse> getListCompanySetting(CompanySettingCriteria companySettingCriteria);

    CompanySettingResponse createCompanySetting(CreateCompanySettingRequest createCompanySettingRequest);

    CompanySettingResponse updateCompanySetting(String companySettingId, UpdateCompanySettingRequest updateCompanySettingRequest);

    List<CompanySettingWithChartOfAccountResponse> getListCompanySettingChartOfAccount();

    Long updateCompanySettingWithChartOfAccount(UpdateCompanyRequestWithChartOfAccountRequest updateCompanyRequestWithChartOfAccountRequest);

    CompanySetting findCompanySettingBySettingNameOrThrowNotFound(String settingName);

    CompanySettingResponse getCompanySetting(String companySettingId);
}
