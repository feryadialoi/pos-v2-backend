package com.gdi.posbackend.command;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandrequest.GetProductsCommandRequest;
import com.gdi.posbackend.model.response.ProductResponse;
import org.springframework.data.domain.Page;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:34 AM
 */
public interface GetProductsCommand extends ConsumerSupplierCommand<Page<ProductResponse>, GetProductsCommandRequest> {
}
