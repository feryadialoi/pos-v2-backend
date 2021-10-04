package com.gdi.posbackend.model.request;

import com.gdi.posbackend.configuration.DateTimeFormatConfiguration;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:36 PM
 */
@Data
public class CreatePurchaseReturnRequest {

    @DateTimeFormat(pattern = DateTimeFormatConfiguration.dateFormat)
    private LocalDate entryDate;

}
