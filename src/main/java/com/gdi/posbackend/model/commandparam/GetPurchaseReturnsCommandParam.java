package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.model.criteria.PurchaseReturnCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 9/21/2021 2:48 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPurchaseReturnsCommandParam implements CommandParam {
    private PurchaseReturnCriteria purchaseReturnCriteria;
    private Pageable pageable;
}
