package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.CompanySettingCategory;
import com.gdi.posbackend.entity.enums.CompanySettingValueType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 8/25/2021 10:23 AM
 */
@Data
public class CreateCompanySettingRequest {

    @NotNull
    @NotBlank
    private String companyId;

    @NotNull
    @NotBlank
    private String displayName;

    @NotNull
    @NotBlank
    private String settingName;

    @NotNull
    @NotBlank
    private String settingValue;

    @NotNull
    private CompanySettingValueType settingValueType;

    @NotNull
    private CompanySettingCategory category;

    private String settingDescription;
}
