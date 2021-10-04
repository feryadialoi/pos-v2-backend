package com.gdi.posbackend.model.criteria;

import com.gdi.posbackend.configuration.DateTimeFormatConfiguration;
import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/18/2021 3:16 PM
 */
@Data
public class PurchaseOrderCriteria {
    private String code;
    private String supplierName;
    private PurchaseOrderStatus status;
    private List<PurchaseOrderStatus> statuses;

    @DateTimeFormat(pattern = DateTimeFormatConfiguration.dateFormat)
    private LocalDate startDate;

    @DateTimeFormat(pattern = DateTimeFormatConfiguration.dateFormat)
    private LocalDate endDate;
}
