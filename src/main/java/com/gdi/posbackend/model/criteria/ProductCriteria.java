package com.gdi.posbackend.model.criteria;

import lombok.Data;
import lombok.Value;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:04 AM
 */
@Value
public class ProductCriteria {
    String name;
    String code;
    String categoryName;
    String brandName;
//    private Long categoryId;
//    private ProductDefaultUnit defaultUnit;
//    private Long unitLargeId;
//    private Long unitMediumId;
//    private Long unitSmallId;
//    private BigDecimal unitLargePrice;
//    private BigDecimal unitMediumPrice;
//    private BigDecimal unitSmallPrice;
//    private BigDecimal minimumStock;
}
