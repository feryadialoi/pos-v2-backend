package com.gdi.posbackend.model.criteria;

import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import lombok.Data;

/**
 * @author Feryadialoi
 * @date 8/18/2021 3:16 PM
 */
@Data
public class PurchaseOrderCriteria {
    private PurchaseOrderStatus status;
    private String supplierName;
    private String code;
    private String startDate;
    private String endDate;
}
