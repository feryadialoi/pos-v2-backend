package com.gdi.posbackend.model.request;

import lombok.Data;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/26/2021 2:49 PM
 */
@Data
public class UpdateCompanyRequestWithChartOfAccountRequest {

    private List<CompanySettingOfCompanySettingWithChartOfAccountRequest> companySettings;


}
