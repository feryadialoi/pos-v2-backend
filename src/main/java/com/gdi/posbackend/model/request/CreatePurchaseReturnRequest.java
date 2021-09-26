package com.gdi.posbackend.model.request;

import com.gdi.posbackend.config.DateConfig;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:36 PM
 */
@Data
public class CreatePurchaseReturnRequest {

    @DateTimeFormat(pattern = DateConfig.dateFormat)
    private LocalDate entryDate;

}
