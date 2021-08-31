package com.gdi.posbackend.model.commandparam.warehouse;

import com.gdi.posbackend.model.commandparam.CommandParam;
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
public class CreateWarehouseCommandParam implements CommandParam {
    private CreateWarehouseRequest createWarehouseRequest;
}
