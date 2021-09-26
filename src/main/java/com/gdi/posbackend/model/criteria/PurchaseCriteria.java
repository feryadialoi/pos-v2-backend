package com.gdi.posbackend.model.criteria;

import com.gdi.posbackend.config.DateConfig;
import com.gdi.posbackend.entity.enums.PurchaseStatus;
import lombok.Data;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author Feryadialoi
 * @date 8/18/2021 3:18 PM
 */
@Data
public class PurchaseCriteria {
    private String code;
    private String supplierName;
    private PurchaseStatus status;

    @DateTimeFormat(pattern = DateConfig.dateFormat)
    private LocalDate startDate;

    @DateTimeFormat(pattern = DateConfig.dateFormat)
    private LocalDate endDate;
}
