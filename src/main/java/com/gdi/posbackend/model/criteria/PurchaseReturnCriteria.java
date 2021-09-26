package com.gdi.posbackend.model.criteria;

import com.gdi.posbackend.config.DateConfig;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:34 PM
 */
@Data
public class PurchaseReturnCriteria {
    @DateTimeFormat(pattern = DateConfig.dateFormat)
    private LocalDate startDate;

    @DateTimeFormat(pattern = DateConfig.dateFormat)
    private LocalDate endDate;
}
