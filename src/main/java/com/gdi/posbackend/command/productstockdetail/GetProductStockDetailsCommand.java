package com.gdi.posbackend.command.productstockdetail;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.GetProductStockDetailsCommandParam;
import com.gdi.posbackend.model.response.ProductStockDetailResponse;
import org.springframework.data.domain.Page;

/**
 * @author Feryadialoi
 * @date 9/17/2021 3:19 PM
 */
public interface GetProductStockDetailsCommand extends ConsumerSupplierCommand<Page<ProductStockDetailResponse>, GetProductStockDetailsCommandParam> {
}
