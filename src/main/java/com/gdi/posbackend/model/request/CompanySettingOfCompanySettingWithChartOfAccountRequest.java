package com.gdi.posbackend.model.request;

import lombok.Data;

/**
 * @author Feryadialoi
 * @date 8/26/2021 2:49 PM
 */
@Data
public class CompanySettingOfCompanySettingWithChartOfAccountRequest {
    private String id;
    private String settingName;
    private String settingValue;
}
