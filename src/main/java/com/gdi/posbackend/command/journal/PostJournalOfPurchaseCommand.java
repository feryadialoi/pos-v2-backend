package com.gdi.posbackend.command.journal;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.PostJournalOfPurchaseCommandParam;

/**
 * @author Feryadialoi
 * @date 8/28/2021 12:59 AM
 */
public interface PostJournalOfPurchaseCommand extends ConsumerSupplierCommand<Void, PostJournalOfPurchaseCommandParam> {
}
