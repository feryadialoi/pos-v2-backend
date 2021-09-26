package com.gdi.posbackend.model.commandparam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:26 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSaleReturnCommandParam implements CommandParam {
    private String saleReturnId;
}
