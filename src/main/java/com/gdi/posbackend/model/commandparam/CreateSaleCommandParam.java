package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.model.request.CreateSaleRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:35 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSaleCommandParam implements CommandParam {
    private CreateSaleRequest createSaleRequest;
}
