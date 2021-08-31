package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.model.request.CreatePurchaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/29/2021 4:07 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePurchaseCommandParam implements CommandParam {
    private CreatePurchaseRequest createPurchaseRequest;
}
