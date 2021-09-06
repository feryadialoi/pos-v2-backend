package com.gdi.posbackend.model;

import com.gdi.posbackend.entity.SaleDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:41 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleCalculatedResult {
    private List<SaleDetail> saleDetails;
    private BigDecimal totalTax;
    private BigDecimal totalDiscount;
    private BigDecimal total;
    private BigDecimal grandTotal;
}
