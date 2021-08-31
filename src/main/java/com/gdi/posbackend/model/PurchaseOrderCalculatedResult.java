package com.gdi.posbackend.model;

import com.gdi.posbackend.entity.PurchaseOrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/28/2021 12:35 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderCalculatedResult {
    List<PurchaseOrderDetail> purchaseOrderDetails;
    BigDecimal totalDiscount;
    BigDecimal totalTax;
    BigDecimal total;
    BigDecimal grandTotal;
}
