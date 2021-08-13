package com.gdi.posbackend.command;

import com.gdi.posbackend.command.core.Command;
import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandrequest.CreateProductCommandRequest;
import com.gdi.posbackend.model.commandrequest.warehouse.CreateWarehouseCommandRequest;
import com.gdi.posbackend.model.response.DetailedProductResponse;

/**
 * @author Feryadialoi
 * @date 8/13/2021 1:46 PM
 */
public interface CreateProductCommand extends ConsumerSupplierCommand<DetailedProductResponse, CreateWarehouseCommandRequest> {
}
