package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.model.request.CreateSaleReturnRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:24 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSaleReturnCommandParam implements CommandParam {
    private CreateSaleReturnRequest createSaleReturnRequest;
}
