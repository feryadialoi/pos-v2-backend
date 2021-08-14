package com.gdi.posbackend.model.commandrequest.warehouse;

import com.gdi.posbackend.model.commandrequest.CommandRequest;
import com.gdi.posbackend.model.request.UpdateWarehouseRequest;
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
public class UpdateWarehouseCommandRequest implements CommandRequest {
    private String warehouseId;
    private UpdateWarehouseRequest updateWarehouseRequest;
}
