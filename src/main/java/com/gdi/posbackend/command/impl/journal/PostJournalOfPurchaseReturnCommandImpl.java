package com.gdi.posbackend.command.impl.journal;

import com.gdi.posbackend.command.journal.PostJournalOfPurchaseReturnCommand;
import com.gdi.posbackend.model.commandparam.PostJournalOfPurchaseReturnCommandParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Feryadialoi
 * @date 8/29/2021 3:59 AM
 */
@Component
@Transactional
@AllArgsConstructor
public class PostJournalOfPurchaseReturnCommandImpl implements PostJournalOfPurchaseReturnCommand {
    @Override
    public Void execute(PostJournalOfPurchaseReturnCommandParam postJournalOfPurchaseReturnCommandParam) {
        return null;
    }
}
