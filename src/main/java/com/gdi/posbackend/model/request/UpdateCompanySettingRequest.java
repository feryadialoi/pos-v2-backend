package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.CompanySettingCategory;
import com.gdi.posbackend.entity.enums.CompanySettingValueType;
import com.gdi.posbackend.validation.constraint.CompanyExists;
import lombok.Data;

/**
 * @author Feryadialoi
 * @date 8/25/2021 10:30 AM
 */
@Data
public class UpdateCompanySettingRequest {

    @CompanyExists
    private String companyId;

    private String displayName;

    private String settingName;

    private String settingValue;

    private CompanySettingValueType settingValueType;

    private CompanySettingCategory category;

    private String settingDescription;
}
