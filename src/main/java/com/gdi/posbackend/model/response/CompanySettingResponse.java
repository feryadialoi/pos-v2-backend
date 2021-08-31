package com.gdi.posbackend.model.response;

import com.gdi.posbackend.entity.enums.CompanySettingCategory;
import com.gdi.posbackend.entity.enums.CompanySettingValueType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/25/2021 10:04 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanySettingResponse {
    private String id;
    private String displayName;
    private String settingName;
    private String settingValue;
    private CompanySettingValueType settingValueType;
    private CompanySettingCategory category;
    private String settingDescription;
}
