package com.gdi.posbackend.command.product;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.UpdateProductCommandParam;
import com.gdi.posbackend.model.response.DetailedProductResponse;

/**
 * @author Feryadialoi
 * @date 9/10/2021 1:46 AM
 */
public interface UpdateProductCommand extends ConsumerSupplierCommand<DetailedProductResponse, UpdateProductCommandParam> {
}
