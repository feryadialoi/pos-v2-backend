package com.gdi.posbackend.command.product;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.CreateProductCommandParam;
import com.gdi.posbackend.model.response.DetailedProductResponse;

/**
 * @author Feryadialoi
 * @date 8/13/2021 1:46 PM
 */
public interface CreateProductCommand extends ConsumerSupplierCommand<DetailedProductResponse, CreateProductCommandParam> {
}
