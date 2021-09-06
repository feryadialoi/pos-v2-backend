package com.gdi.posbackend.model.criteria;

import com.gdi.posbackend.entity.enums.PurchaseStatus;
import lombok.Data;

/**
 * @author Feryadialoi
 * @date 8/18/2021 3:18 PM
 */
@Data
public class PurchaseCriteria {
    private String startDate;
    private String endDate;
    private String supplierName;
    private String code;
    private PurchaseStatus status;
}
