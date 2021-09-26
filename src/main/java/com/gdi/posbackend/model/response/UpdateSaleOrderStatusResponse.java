package com.gdi.posbackend.model.response;

import com.gdi.posbackend.entity.enums.SaleOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/16/2021 1:19 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSaleOrderStatusResponse {
    private String id;
    private SaleOrderStatus status;
}
