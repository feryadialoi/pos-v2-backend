package com.gdi.posbackend.model.criteria;

import com.gdi.posbackend.entity.enums.ProductDefaultUnit;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:04 AM
 */
@Data
public class ProductCriteria {
    private String name;
    private String code;
    private String categoryName;
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
