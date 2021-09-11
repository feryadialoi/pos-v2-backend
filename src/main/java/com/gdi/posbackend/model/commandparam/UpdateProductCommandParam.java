package com.gdi.posbackend.model.commandparam;

import com.gdi.posbackend.model.request.UpdateProductRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 9/10/2021 1:47 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductCommandParam implements CommandParam {
    private String productId;
    private UpdateProductRequest updateProductRequest;
}
