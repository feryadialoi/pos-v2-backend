package com.gdi.posbackend.model.criteria;

import com.gdi.posbackend.config.DateConfig;
import com.gdi.posbackend.entity.enums.SaleOrderStatus;
import lombok.Data;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/18/2021 11:50 PM
 */
@Data
public class SaleOrderCriteria {
    private String code;
    private String salesmanName;
    private String customerName;
    private SaleOrderStatus status;
    private List<SaleOrderStatus> statuses;

    @DateTimeFormat(pattern = DateConfig.dateFormat)
    private LocalDate startDate;

    @DateTimeFormat(pattern = DateConfig.dateFormat)
    private LocalDate endDate;
}
