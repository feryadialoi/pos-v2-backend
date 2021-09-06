package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/3/2021 3:49 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductStockBySaleCommandParam implements CommandParam {
    private Sale sale;
}
