package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/26/2021 11:41 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChartOfAccountOfCompanySettingWithChartOfAccountResponse {
    private String id;
    private String name;
    private Integer accountCode;
}
