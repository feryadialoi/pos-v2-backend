package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.DiscountFormat;
import com.gdi.posbackend.entity.enums.TaxFormat;
import com.gdi.posbackend.validation.constraint.ProductExists;
import com.gdi.posbackend.validation.constraint.UnitExists;
import com.gdi.posbackend.validation.constraint.WarehouseExists;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/20/2021 2:35 PM
 */
@Data
public class ProductOfCreatePurchaseOrderRequest {

    @NotBlank
    @ProductExists
    private String productId;

    @NotBlank
    @WarehouseExists
    private String warehouseId;

    @NotBlank
    @UnitExists
    private String unitId;

    @Min(1)
    private BigDecimal price;

    @Min(1)
    private BigDecimal quantity;

    private BigDecimal discount;

    private DiscountFormat discountFormat;

    private BigDecimal tax;

    private TaxFormat taxFormat;
}
