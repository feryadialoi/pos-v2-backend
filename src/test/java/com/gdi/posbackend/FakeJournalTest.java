package com.gdi.posbackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/28/2021 1:30 AM
 */
public class FakeJournalTest {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class FakeJournal {
        private BigDecimal amount;
    }

    private FakeJournal generateFakeJournalOfInventory() {
        return new FakeJournal(new BigDecimal("50000"));
    }

    private FakeJournal generateFakeJournalOfOtherFee() {
        return null;
    }

    private FakeJournal generateFakeJournalOfShippingFee() {
        return new FakeJournal(new BigDecimal("2000"));
    }

    private FakeJournal generateFakeJournalOfValueAddedTax() {
        return new FakeJournal(new BigDecimal("1000"));
    }

    private FakeJournal generateFakeJournalOfDiscount() {
        return null;
    }


    @Test
    void testPostFakeJournal() {
        List<FakeJournal> fakeJournalList = new ArrayList<>();
        fakeJournalList.add(generateFakeJournalOfInventory());
        fakeJournalList.add(generateFakeJournalOfOtherFee());
        fakeJournalList.add(generateFakeJournalOfShippingFee());
        fakeJournalList.add(generateFakeJournalOfValueAddedTax());
        fakeJournalList.add(generateFakeJournalOfDiscount());

        System.out.println("fake journal list   : " + fakeJournalList.size());
        System.out.println("fake journal list   : " + fakeJournalList);
        System.out.println("==============================================");
        List<FakeJournal> fakeJournalList1 = fakeJournalList.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println("fake journal list 1 : " + fakeJournalList1.size());
        System.out.println("fake journal list 1 : " + fakeJournalList1);
    }
}
