package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.model.request.CreateSaleOrderRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/3/2021 9:20 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSaleOrderCommandParam implements CommandParam {
    private CreateSaleOrderRequest createSaleOrderRequest;
}
