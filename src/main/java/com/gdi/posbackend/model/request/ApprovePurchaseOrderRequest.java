package com.gdi.posbackend.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 8/23/2021 4:24 PM
 */
@Data
public class ApprovePurchaseOrderRequest {
    @NotNull
    @NotBlank
    private String purchaseOrderId;
}
