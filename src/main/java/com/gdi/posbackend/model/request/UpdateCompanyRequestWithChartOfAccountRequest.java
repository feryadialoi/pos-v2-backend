package com.gdi.posbackend.model.request;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/26/2021 2:49 PM
 */
@Data
public class UpdateCompanyRequestWithChartOfAccountRequest {

    @Valid
    private List<CompanySettingOfCompanySettingWithChartOfAccountRequest> companySettings;


}
