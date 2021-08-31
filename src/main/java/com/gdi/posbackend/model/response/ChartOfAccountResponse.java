package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/19/2021 10:13 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChartOfAccountResponse {
    private String id;
    private String name;
    private Integer accountCode;
    private Integer level;
    private String path;
}
