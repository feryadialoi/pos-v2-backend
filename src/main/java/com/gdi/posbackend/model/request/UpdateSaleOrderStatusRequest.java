package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.SaleOrderStatus;
import lombok.Data;
import lombok.Value;

import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 9/16/2021 10:44 AM
 */
@Data
public class UpdateSaleOrderStatusRequest {
    @NotNull
    SaleOrderStatus status;
}
