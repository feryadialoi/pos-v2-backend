package com.gdi.posbackend.model.request;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:22 PM
 */
@Data
public class CreateSaleReturnRequest {
    private LocalDate entryDate;
}
