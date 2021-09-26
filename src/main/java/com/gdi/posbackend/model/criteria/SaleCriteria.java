package com.gdi.posbackend.model.criteria;

import com.gdi.posbackend.config.DateConfig;
import com.gdi.posbackend.entity.enums.SaleStatus;
import lombok.Data;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author Feryadialoi
 * @date 8/18/2021 11:44 PM
 */
@Data
public class SaleCriteria {
    private String code;
    private String salesmanName;
    private String customerName;
    private SaleStatus status;

    @DateTimeFormat(pattern = DateConfig.dateFormat)
    private LocalDate startDate;

    @DateTimeFormat(pattern = DateConfig.dateFormat)
    private LocalDate endDate;
}
