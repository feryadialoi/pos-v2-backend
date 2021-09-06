package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.DiscountFormat;
import com.gdi.posbackend.entity.enums.TaxFormat;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:43 AM
 */
@Data
public class ProductOfCreateSaleRequest {
    private String productId;
    private String unitId;
    private String warehouseId;
    private BigDecimal price;
    private BigDecimal quantity;
    private BigDecimal discount;
    private DiscountFormat discountFormat;
    private BigDecimal tax;
    private TaxFormat taxFormat;
}
