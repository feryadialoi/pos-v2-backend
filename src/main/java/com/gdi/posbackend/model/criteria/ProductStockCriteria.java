package com.gdi.posbackend.model.criteria;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/6/2021 1:28 AM
 */
@Data
public class ProductStockCriteria {
    private String warehouseId;
    private String productName;
    private String productCode;
    private String productCategoryName;

    private BigDecimal stock;
    private BigDecimal stockGt;
    private BigDecimal stockLt;
    private BigDecimal stockGe;
    private BigDecimal stockLe;
}
