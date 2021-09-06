package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.NormalBalance;
import lombok.Data;

/**
 * @author Feryadialoi
 * @date 8/18/2021 3:33 PM
 */
@Data
public class CreateChartOfAccountRequest {
    private String name;
    private Integer accountCode;
    private Integer level;
    private String parentId;
    private NormalBalance normalBalance;
}
