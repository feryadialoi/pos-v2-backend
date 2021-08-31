package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.entity.Purchase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/30/2021 2:27 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductStockByPurchaseCommandParam implements CommandParam {
    private Purchase purchase;
}
