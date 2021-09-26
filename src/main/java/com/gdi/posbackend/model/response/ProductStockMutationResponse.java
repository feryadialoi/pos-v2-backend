package com.gdi.posbackend.model.response;

import com.gdi.posbackend.entity.enums.ProductStockMutationEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 9/17/2021 2:27 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductStockMutationResponse {
    private String id;
    private UnitResponse unit;
    private BigDecimal quantityIn;
    private BigDecimal quantityOut;
    private ProductStockMutationEvent event;
    private String reference;
}
