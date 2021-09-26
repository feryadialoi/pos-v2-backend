package com.gdi.posbackend.command.impl.purchasereturn;

import com.gdi.posbackend.command.purchasereturn.GetPurchaseReturnsCommand;
import com.gdi.posbackend.model.commandparam.GetPurchaseReturnsCommandParam;
import com.gdi.posbackend.model.response.PurchaseReturnResponse;
import com.gdi.posbackend.repository.PurchaseReturnRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/21/2021 2:49 AM
 */
@Component
@AllArgsConstructor
public class GetPurchaseReturnsCommandImpl implements GetPurchaseReturnsCommand {

    private final PurchaseReturnRepository purchaseReturnRepository;

    @Override
    public Page<PurchaseReturnResponse> execute(GetPurchaseReturnsCommandParam getPurchaseReturnsCommandParam) {
        return null;
    }
}
