package com.gdi.posbackend.command.purchaseorder;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.GetPurchaseOrdersCommandParam;
import com.gdi.posbackend.model.response.PurchaseOrderResponse;
import org.springframework.data.domain.Page;

/**
 * @author Feryadialoi
 * @date 9/10/2021 2:26 AM
 */
public interface GetPurchaseOrdersCommand extends ConsumerSupplierCommand<Page<PurchaseOrderResponse>, GetPurchaseOrdersCommandParam> {
}
