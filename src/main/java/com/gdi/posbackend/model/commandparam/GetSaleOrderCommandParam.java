package com.gdi.posbackend.model.commandparam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/2/2021 1:33 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSaleOrderCommandParam implements CommandParam {
    private String saleOrderId;
}
