package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:16 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleReturnResponse {
    private String id;
    private LocalDate entryDate;
    private List<Object> products;
}
