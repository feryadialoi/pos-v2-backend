package com.gdi.posbackend.command.impl.journal;

import com.gdi.posbackend.command.journal.PostJournalOfSaleCommand;
import com.gdi.posbackend.entity.Journal;
import com.gdi.posbackend.entity.JournalDetail;
import com.gdi.posbackend.entity.Sale;
import com.gdi.posbackend.model.commandparam.PostJournalOfSaleCommandParam;
import com.gdi.posbackend.repository.JournalRepository;
import com.gdi.posbackend.service.ChartOfAccountService;
import com.gdi.posbackend.util.NominalUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/29/2021 2:54 AM
 */
@Component
@Transactional
@AllArgsConstructor
public class PostJournalOfSaleCommandImpl implements PostJournalOfSaleCommand {

    // ** repository
    private final JournalRepository journalRepository;

    // ** util
    private final NominalUtil nominalUtil;

    // ** service
    private final ChartOfAccountService chartOfAccountService;

    @Override
    public Void execute(PostJournalOfSaleCommandParam postJournalOfSaleCommandParam) {
        Sale sale = postJournalOfSaleCommandParam.getSale();

        Journal journal = new Journal();
        journal.setName("");
        journal.setCode("");
        journal.setEntryDate(sale.getEntryDate());
        journal.setDebit(BigDecimal.ZERO);
        journal.setCredit(BigDecimal.ZERO);
        journal.setDescription("");
        journal.setJournalDetails(constructJournalDetails(sale, journal));

        journalRepository.save(journal);

        return null;
    }

    private List<JournalDetail> constructJournalDetails(Sale sale, Journal journal) {
        List<JournalDetail> journalDetails = new ArrayList<>();

        journalDetails.add(generateJournalDetailOfInventory(sale, journal));
        journalDetails.add(generateJournalDetailOfValueAddedTax(sale, journal));
        journalDetails.add(generateJournalDetailOfShippingFee(sale, journal));
        journalDetails.add(generateJournalDetailOfDiscount(sale, journal));
        journalDetails.add(generateJournalDetailOfOtherFee(sale, journal));

        return journalDetails;
    }

    private JournalDetail generateJournalDetailOfOtherFee(Sale sale, Journal journal) {
        return null;
    }

    private JournalDetail generateJournalDetailOfDiscount(Sale sale, Journal journal) {
        return null;
    }

    private JournalDetail generateJournalDetailOfShippingFee(Sale sale, Journal journal) {
        return null;
    }

    private JournalDetail generateJournalDetailOfValueAddedTax(Sale sale, Journal journal) {
        return null;
    }

    private JournalDetail generateJournalDetailOfInventory(Sale sale, Journal journal) {
        return null;
    }
}
