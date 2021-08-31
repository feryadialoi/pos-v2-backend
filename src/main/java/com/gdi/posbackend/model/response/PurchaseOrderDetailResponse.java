package com.gdi.posbackend.model.response;

import com.gdi.posbackend.entity.enums.DiscountFormat;
import com.gdi.posbackend.entity.enums.TaxFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/23/2021 2:19 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDetailResponse {
    private String id;
    private ProductResponse product;
    private WarehouseResponse warehouse;
    private UnitResponse unit;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal tax;
    private TaxFormat taxFormat;
    private BigDecimal discount;
    private DiscountFormat discountFormat;
    private BigDecimal amount;
}
