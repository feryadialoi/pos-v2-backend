package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import lombok.Data;

/**
 * @author Feryadialoi
 * @date 9/7/2021 1:25 AM
 */
@Data
public class UpdatePurchaseOrderStatusRequest {
    private PurchaseOrderStatus status;
}
