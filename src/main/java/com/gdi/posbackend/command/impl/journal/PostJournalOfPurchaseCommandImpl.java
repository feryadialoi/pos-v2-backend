package com.gdi.posbackend.command.impl.journal;

import com.gdi.posbackend.command.journal.PostJournalOfPurchaseCommand;
import com.gdi.posbackend.constant.SettingNameOfCompanySetting;
import com.gdi.posbackend.entity.ChartOfAccount;
import com.gdi.posbackend.entity.Journal;
import com.gdi.posbackend.entity.JournalDetail;
import com.gdi.posbackend.entity.Purchase;
import com.gdi.posbackend.exception.ChartOfAccountNotFoundException;
import com.gdi.posbackend.exception.JournalEntryNotBalanceException;
import com.gdi.posbackend.model.commandparam.PostJournalOfPurchaseCommandParam;
import com.gdi.posbackend.repository.ChartOfAccountRepository;
import com.gdi.posbackend.repository.JournalRepository;
import com.gdi.posbackend.service.ChartOfAccountService;
import com.gdi.posbackend.service.CompanySettingService;
import com.gdi.posbackend.util.DiscountUtil;
import com.gdi.posbackend.util.NominalUtil;
import com.gdi.posbackend.util.TaxUtil;
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

    // ** repository
    private final JournalRepository journalRepository;

    // ** util
    private final NominalUtil nominalUtil;

    // ** service
    private final ChartOfAccountService chartOfAccountService;


    @Override
    public Void execute(PostJournalOfPurchaseCommandParam postJournalOfPurchaseCommandParam) {

        // TODO catat purchase terkait ke journal yang dicatat, agar dapat menjadi riwayat penjurnalan dari purchase


        Purchase purchase = postJournalOfPurchaseCommandParam.getPurchase();

        Journal journal = new Journal();
        journal.setName("");
        journal.setCode("");
        journal.setEntryDate(purchase.getEntryDate());
        journal.setDebit(BigDecimal.ZERO);
        journal.setCredit(BigDecimal.ZERO);
        journal.setDescription("");
        journal.setJournalDetails(constructJournalDetails(purchase, journal));

        journalRepository.save(journal);

        return null;
    }

    private List<JournalDetail> constructJournalDetails(Purchase purchase, Journal journal) {

        List<JournalDetail> journalDetails = new ArrayList<>();

        journalDetails.add(generateJournalDetailOfInventory(purchase, journal));
        journalDetails.add(generateJournalDetailOfValueAddedTax(purchase, journal));
        journalDetails.add(generateJournalDetailOfShippingFee(purchase, journal));
        journalDetails.add(generateJournalDetailOfDiscount(purchase, journal));
        journalDetails.add(generateJournalDetailOfOtherFee(purchase, journal));

        List<JournalDetail> filteredJournalDetails = journalDetails.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        BigDecimal totalDebit = BigDecimal.ZERO;
        BigDecimal totalCredit = BigDecimal.ZERO;

        for (JournalDetail journalDetail : filteredJournalDetails) {
            totalDebit = totalDebit.add(journalDetail.getDebit());
            totalCredit = totalCredit.add(journalDetail.getCredit());
        }

        if (totalDebit.compareTo(totalCredit) == 0) {
            // then journal is balance, continue to the next step (persisting data, etc...)
            return journalDetails;
        } else {
            throw new JournalEntryNotBalanceException("journal entry not balance for purchase with id " + purchase.getId());
        }

    }

    private JournalDetail generateJournalDetailOfInventory(Purchase purchase, Journal journal) {
        JournalDetail journalDetail = new JournalDetail();
        journalDetail.setJournal(journal);
        journalDetail.setChartOfAccount(chartOfAccountService.getChartOfAccountOfCompanySetting(SettingNameOfCompanySetting.ACCOUNTING));
        journalDetail.setDebit(BigDecimal.ZERO);
        journalDetail.setCredit(BigDecimal.ZERO);
        journalDetail.setEntryDate(purchase.getEntryDate());
        journalDetail.setDescription("");

        return journalDetail;
    }

    private JournalDetail generateJournalDetailOfDiscount(Purchase purchase, Journal journal) {
        if (nominalUtil.isNominalNotZero(purchase.getDiscount())) {

            JournalDetail journalDetail = new JournalDetail();
            journalDetail.setJournal(journal);
            journalDetail.setChartOfAccount(chartOfAccountService.getChartOfAccountOfCompanySetting(SettingNameOfCompanySetting.COA_DISCOUNT_IN));
            journalDetail.setDebit(BigDecimal.ZERO);
            journalDetail.setCredit(BigDecimal.ZERO);
            journalDetail.setEntryDate(purchase.getEntryDate());
            journalDetail.setDescription("");

            return journalDetail;
        }
        return null;
    }

    private JournalDetail generateJournalDetailOfShippingFee(Purchase purchase, Journal journal) {
        if (nominalUtil.isNominalNotZero(purchase.getShippingFee())) {
            JournalDetail journalDetail = new JournalDetail();

            journalDetail.setDebit(BigDecimal.ZERO);
            journalDetail.setCredit(BigDecimal.ZERO);
            journalDetail.setEntryDate(purchase.getEntryDate());
            journalDetail.setDescription("");

            return journalDetail;
        }
        return null;
    }

    private JournalDetail generateJournalDetailOfValueAddedTax(Purchase purchase, Journal journal) {
        if (nominalUtil.isNominalNotZero(purchase.getTax())) {
            ChartOfAccount chartOfAccount = chartOfAccountService.getChartOfAccountOfCompanySetting(SettingNameOfCompanySetting.COA_TAX_IN);

            JournalDetail journalDetail = new JournalDetail();

            return journalDetail;
        }

        return null;
    }

    private JournalDetail generateJournalDetailOfOtherFee(Purchase purchase, Journal journal) {
        if (nominalUtil.isNominalNotZero(purchase.getOtherFee())) {
            ChartOfAccount chartOfAccount = chartOfAccountService.getChartOfAccountOfCompanySetting(SettingNameOfCompanySetting.COA_OTHER_FEE);

            JournalDetail journalDetail = new JournalDetail();

            return journalDetail;
        }

        return null;
    }

}
