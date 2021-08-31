package com.gdi.posbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/25/2021 1:25 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseJournal {
    private BigDecimal amount;
    private BigDecimal tax;
    private BigDecimal discount;
    private BigDecimal shippingFee;
    private BigDecimal otherFee;
}
