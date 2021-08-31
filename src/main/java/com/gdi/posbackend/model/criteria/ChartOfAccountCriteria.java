package com.gdi.posbackend.model.criteria;

import lombok.Data;

/**
 * @author Feryadialoi
 * @date 8/18/2021 3:31 PM
 */
@Data
public class ChartOfAccountCriteria {
    private String name;
    private String accountCode;
    private Integer level;
}
