package com.gdi.posbackend.model.response;

import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/7/2021 1:26 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePurchaseOrderStatusResponse {
    private String id;
    private PurchaseOrderStatus status;
}
