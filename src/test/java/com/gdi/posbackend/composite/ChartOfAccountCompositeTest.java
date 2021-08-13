package com.gdi.posbackend.composite;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Feryadialoi
 * @date 7/27/2021 10:04 AM
 */
class ChartOfAccountCompositeTest {
    /**
     * 1 Aktiva
     * 1.0 Aktiva lancar
     * 1.0.1 Kas
     * 1.0.2 Piutang usaha
     * 1.1 Investasi jangka panjang
     * 1.1.1 Investasi saham
     * 1.1.2 Investasi obligasi
     * 1.2 Aktiva tetap
     * 1.2.1 Peralatan toko
     * 1.2.2 Akumulasi penyusutan peralatan toko dan seterusnya
     * 1.3 Persediaan bahan baku
     * 1.3.1 Bahan baku kayu
     * 1.3.1.1 Bahan baku kayu jati
     * 1.3.1.2 Bahan baku kayu mahoni
     * 1.3.1.3 Bahan baku kayu albasia
     * 1.3.2 Bahan baku eceng gondok
     * 1.3.3 Bahan baku pelepah pisang
     * 1.3.4 Bahan baku bambu
     */
    @Test
    void test() {
        ChartOfAccount chartOfAccount = new ChartOfAccountComposite("Aktiva", "1",
                Arrays.asList(
                        new ChartOfAccountComposite("Aktiva lancar", "1.0",
                                Arrays.asList(
                                        new ChartOfAccount("Kas", "1.0.1"),
                                        new ChartOfAccount("Piutang usaha", "1.0.2")
                                )),
                        new ChartOfAccountComposite("Investasi jangka panjang", "1.1",
                                Arrays.asList(
                                        new ChartOfAccount("Investasi saham", "1.1.1"),
                                        new ChartOfAccount("Investasi obligasi", "1.1.2")
                                )),
                        new ChartOfAccountComposite("Aktiva tetap", "1.2",
                                Arrays.asList(
                                        new ChartOfAccount("Peralatan toko", "1.2.1"),
                                        new ChartOfAccount("Akumulasi penyusutan peralatan toko dan seterusnya", "1.2.2")
                                )),
                        new ChartOfAccountComposite("Persediaan bahan baku", "1.3",
                                Arrays.asList(
                                        new ChartOfAccountComposite("Bahan baku kayu", "1.3.1",
                                                Arrays.asList(
                                                        new ChartOfAccount("Bahan baku kayu jati", "1.3.1.1"),
                                                        new ChartOfAccount("Bahan baku kayu mahoni", "1.3.1.2"),
                                                        new ChartOfAccount("Bahan baku kayu albasia", "1.3.1.3")
                                                )),
                                        new ChartOfAccount("Bahan baku eceng gondok", "1.3.2"),
                                        new ChartOfAccount("Bahan baku pelepah pisang", "1.3.3"),
                                        new ChartOfAccount("Bahan baku bambu", "1.3.4")
                                ))
                )
        );

        List<ChartOfAccount> chartOfAccounts = new ArrayList<>();

        visit(chartOfAccount, this::printCoa);

        visit(chartOfAccount, (account) -> {
            chartOfAccounts.add(new ChartOfAccount(account.getName(), account.getAccountCode()));
        });

        System.out.println(chartOfAccount);
        System.out.println(chartOfAccounts.size());

    }

    private void visit(ChartOfAccount chartOfAccount, Consumer<ChartOfAccount> consumer) {
        consumer.accept(chartOfAccount);

        if (chartOfAccount instanceof ChartOfAccountComposite) {
            List<ChartOfAccount> children = ((ChartOfAccountComposite) chartOfAccount).getChildren();
            for (ChartOfAccount account : children) {
                visit(account, consumer);
            }
        }
    }

    private void printCoa(ChartOfAccount account) {
        System.out.println(account.getAccountCode() + " " + account.getName());
    }

}