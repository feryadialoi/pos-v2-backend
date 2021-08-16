package com.gdi.posbackend.model.commandrequest.warehouse;

import com.gdi.posbackend.model.commandrequest.CommandRequest;
import com.gdi.posbackend.model.request.CreateProductRequest;
import com.gdi.posbackend.model.request.CreateWarehouseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 8/5/2021 12:04 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateWarehouseCommandRequest implements CommandRequest {
    private CreateWarehouseRequest createWarehouseRequest;
}