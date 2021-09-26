package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 9/7/2021 1:25 AM
 */
@Data
public class UpdatePurchaseOrderStatusRequest {
    @NotNull
    private PurchaseOrderStatus status;
}
