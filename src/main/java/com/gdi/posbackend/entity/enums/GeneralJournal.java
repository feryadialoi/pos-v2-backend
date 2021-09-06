package com.gdi.posbackend.entity.enums;

/**
 * @author Feryadialoi
 * @date 9/4/2021 10:39 PM
 */
public enum GeneralJournal implements JournalTransaction {

    ACCRUAL, // akrual /
    ADJUSTMENT, // penyesuaian
    CORRECTION_OF_ERROR, // koreksi kesalahan
    DEPRECIATION, // penyusutan
    PREPAYMENT, // pembayaran di muka
    SALE_OF_NON_CURRENT_ASSET, // penjualan aset tidak lancar/aset tetap
    PURCHASE_OF_NON_CURRENT_ASSET, // pembelian aset tidak lancar/aset tetap
    BAD_DEBT, // piutang tak tertagih


}