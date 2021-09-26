package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.model.request.UpdateSaleOrderStatusRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/16/2021 1:24 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSaleOrderStatusCommandParam implements CommandParam {
    private String saleOrderId;
    private UpdateSaleOrderStatusRequest updateSaleOrderStatusRequest;
}
