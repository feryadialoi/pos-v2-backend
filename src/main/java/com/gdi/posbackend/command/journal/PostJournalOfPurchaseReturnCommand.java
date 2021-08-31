package com.gdi.posbackend.command.journal;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.PostJournalOfPurchaseReturnCommandParam;

/**
 * @author Feryadialoi
 * @date 8/29/2021 3:52 AM
 */
public interface PostJournalOfPurchaseReturnCommand extends ConsumerSupplierCommand<Void, PostJournalOfPurchaseReturnCommandParam> {
}
