package com.gdi.posbackend.model.commandparam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/17/2021 2:31 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetProductStockDetailWithProductStockMutationsCommandParam implements CommandParam{
    private String productStockDetailId;
}
