package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:36 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailedPurchaseReturnResponse {
    private String id;
    private LocalDate entryDate;
}
