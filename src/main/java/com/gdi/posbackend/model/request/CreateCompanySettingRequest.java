package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.CompanySettingCategory;
import com.gdi.posbackend.entity.enums.CompanySettingValueType;
import com.gdi.posbackend.validation.constraint.CompanyExists;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 8/25/2021 10:23 AM
 */
@Data
public class CreateCompanySettingRequest {

    @NotBlank
    @CompanyExists
    private String companyId;

    @NotBlank
    private String displayName;

    @NotBlank
    private String settingName;

    @NotBlank
    private String settingValue;

    @NotNull
    private CompanySettingValueType settingValueType;

    @NotNull
    private CompanySettingCategory category;

    private String settingDescription;
}
