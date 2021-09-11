package com.gdi.posbackend.model.commandparam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/10/2021 12:31 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteProductCommandParam implements CommandParam {
    private String productId;
}
