package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.model.request.UpdatePurchaseOrderStatusRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/10/2021 2:30 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePurchaseOrderStatusCommandParam implements CommandParam {
    private String purchaseOrderId;
    private UpdatePurchaseOrderStatusRequest updatePurchaseOrderStatusRequest;
}
