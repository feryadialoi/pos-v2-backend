package com.gdi.posbackend.model.commandparam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/17/2021 10:54 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSaleCommandParam implements CommandParam {
    private String saleId;
}
