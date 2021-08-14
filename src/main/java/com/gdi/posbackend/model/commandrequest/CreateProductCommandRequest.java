package com.gdi.posbackend.model.commandrequest;

import com.gdi.posbackend.model.request.CreateProductRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Feryadialoi
 * @date 8/13/2021 1:48 PM
 */
@Data
@AllArgsConstructor
public class CreateProductCommandRequest implements CommandRequest {
    private CreateProductRequest createProductRequest;
}
