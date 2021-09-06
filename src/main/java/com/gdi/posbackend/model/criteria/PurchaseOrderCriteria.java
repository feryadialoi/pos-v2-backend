package com.gdi.posbackend.model.criteria;

import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import lombok.Data;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/18/2021 3:16 PM
 */
@Data
public class PurchaseOrderCriteria {
    private String startDate;
    private String endDate;
    private String supplierName;
    private String code;
    private PurchaseOrderStatus status;
    private List<PurchaseOrderStatus> statuses;
}
