package com.gdi.posbackend.model.criteria;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 9/17/2021 2:48 PM
 */
@Data
public class ProductStockDetailCriteria {
    private String productName;
    private String productStockId;
    private String batch;
    private BigDecimal quantity;
    private BigDecimal quantityLt;
    private BigDecimal quantityGt;
    private BigDecimal quantityGe;
    private BigDecimal quantityLe;
}
