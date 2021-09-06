package com.gdi.posbackend.entity.enums;

/**
 * @author Feryadialoi
 * @date 9/4/2021 10:13 PM
 */
public enum SpecialJournal implements JournalTransaction {

    PURCHASE, // pembelian
    RETURN_PURCHASE, // retur pembelian
    SALE, // penjualan
    RETURN_SALE, // retur penjualan
    CASH_RECEIPT, // penerimaan kas
    CASH_PAYMENT, // pengeluaran kas

}
