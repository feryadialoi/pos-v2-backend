package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 9/26/2021 10:45 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimplifiedProductStockResponse {
    private String id;
    private SimplifiedProductResponse product;
    private BigDecimal stock;
    private UnitResponse unit;
}
