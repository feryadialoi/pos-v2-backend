package com.gdi.posbackend.model;

import com.gdi.posbackend.entity.PurchaseDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/28/2021 12:36 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseCalculatedResult {
    List<PurchaseDetail> purchaseDetails;
    BigDecimal totalDiscount;
    BigDecimal totalTax;
    BigDecimal total;
    BigDecimal grandTotal;
}
