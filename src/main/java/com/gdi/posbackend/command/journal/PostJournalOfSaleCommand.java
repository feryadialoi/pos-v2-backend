package com.gdi.posbackend.command.journal;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.model.commandparam.PostJournalOfSaleCommandParam;

/**
 * @author Feryadialoi
 * @date 8/29/2021 2:53 AM
 */
public interface PostJournalOfSaleCommand extends ConsumerSupplierCommand<Void, PostJournalOfSaleCommandParam> {
}
