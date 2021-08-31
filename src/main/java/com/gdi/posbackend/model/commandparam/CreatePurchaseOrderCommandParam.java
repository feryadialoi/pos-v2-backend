package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.model.request.CreatePurchaseOrderRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/29/2021 5:27 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePurchaseOrderCommandParam implements CommandParam {
    private CreatePurchaseOrderRequest createPurchaseOrderRequest;
}
