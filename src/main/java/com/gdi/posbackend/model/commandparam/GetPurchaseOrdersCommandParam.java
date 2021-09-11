package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.model.criteria.PurchaseOrderCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 9/10/2021 2:26 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPurchaseOrdersCommandParam implements CommandParam {
    private PurchaseOrderCriteria purchaseOrderCriteria;
    private Pageable pageable;
}
