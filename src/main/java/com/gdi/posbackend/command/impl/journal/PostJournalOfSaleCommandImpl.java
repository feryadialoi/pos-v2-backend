package com.gdi.posbackend.command.impl.journal;

import com.gdi.posbackend.command.journal.PostJournalOfSaleCommand;
import com.gdi.posbackend.model.commandparam.PostJournalOfSaleCommandParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Feryadialoi
 * @date 8/29/2021 2:54 AM
 */
@Component
@Transactional
@AllArgsConstructor
public class PostJournalOfSaleCommandImpl implements PostJournalOfSaleCommand {
    @Override
    public Void execute(PostJournalOfSaleCommandParam postJournalOfSaleCommandParam) {
        return null;
    }
}
