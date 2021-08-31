package com.gdi.posbackend.command.journal;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.PostJournalOfSaleReturnCommandParam;

/**
 * @author Feryadialoi
 * @date 8/29/2021 3:58 AM
 */
public interface PostJournalOfSaleReturnCommand extends ConsumerSupplierCommand<Void, PostJournalOfSaleReturnCommandParam> {
}
