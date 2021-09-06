package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.model.criteria.SaleOrderCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 9/2/2021 1:30 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSaleOrdersCommandParam implements CommandParam {
    private SaleOrderCriteria saleOrderCriteria;
    private Pageable pageable;
}
