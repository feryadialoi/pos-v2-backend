package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.DiscountFormat;
import com.gdi.posbackend.entity.enums.TaxFormat;
import com.gdi.posbackend.validation.constraint.ProductExists;
import com.gdi.posbackend.validation.constraint.ProductStockSufficientForSaleOrder;
import com.gdi.posbackend.validation.constraint.UnitExists;
import com.gdi.posbackend.validation.constraint.WarehouseExists;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 9/3/2021 9:45 AM
 */
@Data
@ProductStockSufficientForSaleOrder
public class ProductOfCreateSaleOrderRequest {

    @NotBlank
    @ProductExists
    private String productId;

    @NotBlank
    @UnitExists
    private String unitId;

    @NotBlank
    @WarehouseExists
    private String warehouseId;

    @Min(1)
    private BigDecimal price;

    @Min(1)
    private BigDecimal quantity;

    private BigDecimal discount;

    private DiscountFormat discountFormat;

    private BigDecimal tax;

    private TaxFormat taxFormat;

}
