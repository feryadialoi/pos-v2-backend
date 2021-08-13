package com.gdi.posbackend.model.criteria;

import lombok.Data;

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
}
