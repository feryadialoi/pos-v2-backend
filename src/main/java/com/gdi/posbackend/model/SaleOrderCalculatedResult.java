package com.gdi.posbackend.model;

import com.gdi.posbackend.entity.SaleOrderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:16 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrderCalculatedResult {
    private List<SaleOrderDetail> saleOrderDetails;
    BigDecimal totalDiscount;
    BigDecimal totalTax;
    BigDecimal total;
    BigDecimal grandTotal;
}
