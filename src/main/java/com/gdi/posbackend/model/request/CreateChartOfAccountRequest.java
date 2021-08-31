package com.gdi.posbackend.model.request;

import lombok.Data;

/**
 * @author Feryadialoi
 * @date 8/18/2021 3:33 PM
 */
@Data
public class CreateChartOfAccountRequest {
    private String name;
    private String accountCode;
    private String level;
    private String parentId;
}
