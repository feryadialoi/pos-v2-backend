package com.gdi.posbackend.entity.enums;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/4/2021 10:13 PM
 */
public enum JournalType {

    GENERAL(List.of(GeneralJournal.ACCRUAL,
            GeneralJournal.ADJUSTMENT,
            GeneralJournal.CORRECTION_OF_ERROR,
            GeneralJournal.DEPRECIATION,
            GeneralJournal.PREPAYMENT,
            GeneralJournal.SALE_OF_NON_CURRENT_ASSET,
            GeneralJournal.PURCHASE_OF_NON_CURRENT_ASSET,
            GeneralJournal.BAD_DEBT)),

    SPECIAL(List.of(SpecialJournal.PURCHASE,
            SpecialJournal.RETURN_PURCHASE,
            SpecialJournal.SALE,
            SpecialJournal.RETURN_SALE,
            SpecialJournal.CASH_RECEIPT,
            SpecialJournal.CASH_PAYMENT));

    private final List<JournalTransaction> journalTypeTransactions;

    JournalType(List<JournalTransaction> journalTypeTransactions) {
        this.journalTypeTransactions = journalTypeTransactions;
    }

    public List<JournalTransaction> getJournalTypeTransactions() {
        return journalTypeTransactions;
    }
}
