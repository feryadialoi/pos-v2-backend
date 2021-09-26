package com.gdi.posbackend.command.purchasereturn;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.GetPurchaseReturnsCommandParam;
import com.gdi.posbackend.model.response.PurchaseReturnResponse;
import org.springframework.data.domain.Page;

/**
 * @author Feryadialoi
 * @date 9/20/2021 11:43 PM
 */
public interface GetPurchaseReturnsCommand extends ConsumerSupplierCommand<Page<PurchaseReturnResponse>, GetPurchaseReturnsCommandParam> {
}
