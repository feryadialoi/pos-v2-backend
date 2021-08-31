package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.journal.PostJournalOfPurchaseCommand;
import com.gdi.posbackend.command.journal.PostJournalOfPurchaseReturnCommand;
import com.gdi.posbackend.command.journal.PostJournalOfSaleCommand;
import com.gdi.posbackend.command.journal.PostJournalOfSaleReturnCommand;
import com.gdi.posbackend.entity.Purchase;
import com.gdi.posbackend.entity.PurchaseReturn;
import com.gdi.posbackend.entity.Sale;
import com.gdi.posbackend.entity.SaleReturn;
import com.gdi.posbackend.model.commandparam.PostJournalOfPurchaseCommandParam;
import com.gdi.posbackend.model.commandparam.PostJournalOfPurchaseReturnCommandParam;
import com.gdi.posbackend.model.commandparam.PostJournalOfSaleCommandParam;
import com.gdi.posbackend.model.commandparam.PostJournalOfSaleReturnCommandParam;
import com.gdi.posbackend.service.JournalService;
import com.gdi.posbackend.service.ServiceExecutor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Feryadialoi
 * @date 8/28/2021 12:54 AM
 */
@Service
@Transactional
@AllArgsConstructor
public class JournalServiceImpl implements JournalService {

    private final ServiceExecutor serviceExecutor;

    @Override
    public void postJournalOfPurchase(Purchase purchase) {
        serviceExecutor.execute(PostJournalOfPurchaseCommand.class, new PostJournalOfPurchaseCommandParam(purchase));
    }

    @Override
    public void postJournalOfSale(Sale sale) {
        serviceExecutor.execute(PostJournalOfSaleCommand.class, new PostJournalOfSaleCommandParam(sale));
    }

    @Override
    public void postJournalOfPurchaseReturn(PurchaseReturn purchaseReturn) {
        serviceExecutor.execute(PostJournalOfPurchaseReturnCommand.class, new PostJournalOfPurchaseReturnCommandParam(purchaseReturn));
    }

    @Override
    public void postJournalOfSaleReturn(SaleReturn saleReturn) {
        serviceExecutor.execute(PostJournalOfSaleReturnCommand.class, new PostJournalOfSaleReturnCommandParam(saleReturn));
    }

}
