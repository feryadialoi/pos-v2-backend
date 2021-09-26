package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.model.criteria.SaleReturnCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:28 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSaleReturnsCommandParam implements CommandParam {
    private SaleReturnCriteria saleReturnCriteria;
    private Pageable pageable;
}
