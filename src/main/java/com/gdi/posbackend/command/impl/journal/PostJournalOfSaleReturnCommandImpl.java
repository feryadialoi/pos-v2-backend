package com.gdi.posbackend.command.impl.journal;

import com.gdi.posbackend.command.journal.PostJournalOfSaleReturnCommand;
import com.gdi.posbackend.model.commandparam.PostJournalOfSaleReturnCommandParam;
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
public class PostJournalOfSaleReturnCommandImpl implements PostJournalOfSaleReturnCommand {
    @Override
    public Void execute(PostJournalOfSaleReturnCommandParam postJournalOfSaleReturnCommandParam) {
        return null;
    }
}
