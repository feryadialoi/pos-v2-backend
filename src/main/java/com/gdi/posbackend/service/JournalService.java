package com.gdi.posbackend.service;

import com.gdi.posbackend.command.journal.PostJournalOfPurchaseCommand;
import com.gdi.posbackend.command.journal.PostJournalOfPurchaseReturnCommand;
import com.gdi.posbackend.command.journal.PostJournalOfSaleCommand;
import com.gdi.posbackend.command.journal.PostJournalOfSaleReturnCommand;
import com.gdi.posbackend.entity.Purchase;
import com.gdi.posbackend.entity.PurchaseReturn;
import com.gdi.posbackend.entity.Sale;
import com.gdi.posbackend.entity.SaleReturn;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.model.PurchaseJournal;
import com.gdi.posbackend.model.PurchaseReturnJournal;
import com.gdi.posbackend.model.SaleJournal;
import com.gdi.posbackend.model.SaleReturnJournal;
import com.gdi.posbackend.model.commandparam.PostJournalOfPurchaseCommandParam;
import com.gdi.posbackend.model.commandparam.PostJournalOfPurchaseReturnCommandParam;
import com.gdi.posbackend.model.commandparam.PostJournalOfSaleCommandParam;
import com.gdi.posbackend.model.commandparam.PostJournalOfSaleReturnCommandParam;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/20/2021 1:49 AM
 */
public interface JournalService {

    void postJournalOfPurchase(Purchase purchase);

    void postJournalOfSale(Sale sale);

    void postJournalOfPurchaseReturn(PurchaseReturn purchaseReturn);

    void postJournalOfSaleReturn(SaleReturn saleReturn);

}
