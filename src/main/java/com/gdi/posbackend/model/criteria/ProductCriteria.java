package com.gdi.posbackend.model.criteria;

import lombok.Data;
import lombok.Value;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:04 AM
 */
@Data
public class ProductCriteria {
    private String name;
    private String code;
    private String categoryName;
    private String brandName;
}
