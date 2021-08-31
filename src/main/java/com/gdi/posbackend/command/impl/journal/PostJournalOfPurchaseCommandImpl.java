package com.gdi.posbackend.command.impl.journal;

import com.gdi.posbackend.command.journal.PostJournalOfPurchaseCommand;
import com.gdi.posbackend.constant.SettingNameOfCompanySetting;
import com.gdi.posbackend.entity.ChartOfAccount;
import com.gdi.posbackend.entity.Journal;
import com.gdi.posbackend.entity.JournalDetail;
import com.gdi.posbackend.entity.Purchase;
import com.gdi.posbackend.exception.ChartOfAccountNotFoundException;
import com.gdi.posbackend.model.commandparam.PostJournalOfPurchaseCommandParam;
import com.gdi.posbackend.repository.ChartOfAccountRepository;
import com.gdi.posbackend.repository.JournalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/29/2021 2:52 AM
 */
@Component
@Transactional
@AllArgsConstructor
public class PostJournalOfPurchaseCommandImpl implements PostJournalOfPurchaseCommand {

    private final JournalRepository journalRepository;
    private final ChartOfAccountRepository chartOfAccountRepository;

    @Override
    public Void execute(PostJournalOfPurchaseCommandParam postJournalOfPurchaseCommandParam) {

        Purchase purchase = postJournalOfPurchaseCommandParam.getPurchase();

        Journal journal = new Journal();
        journal.setName("");
        journal.setCode("");
        journal.setEntryDate(LocalDateTime.now());
        journal.setDebit(BigDecimal.ZERO);
        journal.setCredit(BigDecimal.ZERO);
        journal.setDescription("");
        journal.setJournalDetails(constructJournalDetails(purchase, journal));

        journalRepository.save(journal);

        return null;
    }

    private List<JournalDetail> constructJournalDetails(Purchase purchase, Journal journal) {
        List<JournalDetail> journalDetails = new ArrayList<>();

        journalDetails.add(generateJournalDetailOfInventory(journal));
        journalDetails.add(generateJournalDetailOfValueAddedTax(journal));
        journalDetails.add(generateJournalDetailOfShippingFee(journal));
        journalDetails.add(generateJournalDetailOfDiscount(journal));
        journalDetails.add(generateJournalDetailOfOtherFee(journal));

        return journalDetails.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    private JournalDetail generateJournalDetailOfInventory(Journal journal) {
        JournalDetail journalDetail = new JournalDetail();
        journalDetail.setJournal(journal);
        journalDetail.setDebit(BigDecimal.ZERO);
        journalDetail.setCredit(BigDecimal.ZERO);
        journalDetail.setEntryDate(LocalDateTime.now());
        journalDetail.setChartOfAccount(getChartOfAccountInCompanySetting(SettingNameOfCompanySetting.ACCOUNTING));
        journalDetail.setDescription("");

        return null;
    }

    private JournalDetail generateJournalDetailOfDiscount(Journal journal) {


        return null;
    }

    private JournalDetail generateJournalDetailOfShippingFee(Journal journal) {
        return null;
    }

    private JournalDetail generateJournalDetailOfValueAddedTax(Journal journal) {
        return null;
    }

    private JournalDetail generateJournalDetailOfOtherFee(Journal journal) {
        return null;
    }

    private ChartOfAccount getChartOfAccountInCompanySetting(SettingNameOfCompanySetting settingNameOfCompanySetting) {
        return chartOfAccountRepository.findByCompanySetting(settingNameOfCompanySetting.name())
                .orElseThrow(() -> new ChartOfAccountNotFoundException("chart of account by company setting of "
                        + settingNameOfCompanySetting.name() + " not found")
                );
    }
}
