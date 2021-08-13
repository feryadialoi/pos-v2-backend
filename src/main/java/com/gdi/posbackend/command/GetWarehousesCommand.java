package com.gdi.posbackend.command;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandrequest.warehouse.GetWarehousesCommandRequest;
import com.gdi.posbackend.model.response.WarehouseResponse;
import org.springframework.data.domain.Page;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:33 AM
 */
public interface GetWarehousesCommand extends ConsumerSupplierCommand<Page<WarehouseResponse>, GetWarehousesCommandRequest> {
}
