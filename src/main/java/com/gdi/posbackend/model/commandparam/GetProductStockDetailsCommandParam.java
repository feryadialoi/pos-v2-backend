package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.model.criteria.ProductStockDetailCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 9/17/2021 3:19 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetProductStockDetailsCommandParam implements CommandParam {
    private ProductStockDetailCriteria productStockDetailCriteria;
    private Pageable pageable;
}
