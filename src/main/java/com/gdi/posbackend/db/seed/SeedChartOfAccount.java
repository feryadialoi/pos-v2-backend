package com.gdi.posbackend.db.seed;

import com.gdi.posbackend.entity.ChartOfAccount;
import com.gdi.posbackend.entity.enums.NormalBalance;
import com.gdi.posbackend.repository.ChartOfAccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/25/2021 2:54 PM
 */
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class SeedChartOfAccount {
    // @formatter:off
    private final ChartOfAccountRepository chartOfAccountRepository;

    public void seed() {
        if (chartOfAccountRepository.count() == 0) {
            account1();
            account2();
            account3();
            account4();
            account5();
            account6();
        }
    }
    public void account1() {
        ChartOfAccount aset                         = new ChartOfAccount("Aset",                          1,   1, null,"1",         NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount asetLancar                   = new ChartOfAccount("Aset Lancar",                   11,  2, aset,      "1/11",    NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount kasKecil                     = new ChartOfAccount("Kas Kecil",                     1101,3, asetLancar,"1/11/1101", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount kasBesar                     = new ChartOfAccount("Kas Besar",                     1102,3, asetLancar,"1/11/1102", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount persediaanBarangDagang       = new ChartOfAccount("Persediaan Barang Dagang",      1103,3, asetLancar,"1/11/1103", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount piutangUsaha                 = new ChartOfAccount("Piutang Usaha",                 1104,3, asetLancar,"1/11/1104", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount penyisihanPiutangUsaha       = new ChartOfAccount("Penyisihan Piutang Usaha",      1105,3, asetLancar,"1/11/1105", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount weselTagih                   = new ChartOfAccount("Wesel Tagih",                   1106,3, asetLancar,"1/11/1106", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount perlengkapan                 = new ChartOfAccount("Perlengkapan",                  1107,3, asetLancar,"1/11/1107", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount iklanDibayarDimuka           = new ChartOfAccount("Iklan Dibayar Dimuka",          1108,3, asetLancar,"1/11/1108", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount sewaDibayarDimuka            = new ChartOfAccount("Sewa Dibayar Dimuka",           1109,3, asetLancar,"1/11/1109", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount asuransiDibayarDimuka        = new ChartOfAccount("Asuransi Dibayar Dimuka",       1110,3, asetLancar,"1/11/1110", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount investasiJangkaPanjang       = new ChartOfAccount("Investasi Jangka Panjang",      12,  2, aset,      "1/12",      NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount asetTetap                    = new ChartOfAccount("Aset Tetap",                    13,  2, aset,      "1/13",      NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount peralatan                    = new ChartOfAccount("Peralatan",                     1301,3, asetTetap, "1/13/1301", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount akumulasiPenyusutanPeralatan = new ChartOfAccount("Akumulasi Penyusutan Peralatan",1302,3, asetTetap, "1/13/1302", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount kendaraan                    = new ChartOfAccount("Kendaraan",                     1303,3, asetTetap, "1/13/1303", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount akumulasiPenyusutanKendaraan = new ChartOfAccount("Akumulasi Penyusutan Kendaraan",1304,3, asetTetap, "1/13/1304", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount gedung                       = new ChartOfAccount("Gedung",                        1305,3, asetTetap, "1/13/1305", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount akumulasiPenyusutanGedung    = new ChartOfAccount("Akumulasi Penyusutan Gedung",   1306,3, asetTetap, "1/13/1306", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount tanah                        = new ChartOfAccount("Tanah",                         1307,3, asetTetap, "1/13/1307", NormalBalance.DEBIT, Collections.emptyList());

        chartOfAccountRepository.saveAll(List.of(
                aset,
                asetLancar,
                kasKecil,
                kasBesar,
                persediaanBarangDagang,
                piutangUsaha,
                penyisihanPiutangUsaha,
                weselTagih,
                perlengkapan,
                iklanDibayarDimuka,
                sewaDibayarDimuka,
                asuransiDibayarDimuka,
                investasiJangkaPanjang,
                asetTetap,
                peralatan,
                akumulasiPenyusutanPeralatan,
                kendaraan,
                akumulasiPenyusutanKendaraan,
                gedung,
                akumulasiPenyusutanGedung,
                tanah
        ));
    }

    public void account2() {
        ChartOfAccount kewajiban                           = new ChartOfAccount("Kewajiban",                        2,   1, null,"2",      NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount kewajibanLancar                     = new ChartOfAccount("Kewajiban Lancar",                 21,  2, kewajiban, "2/21",   NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount utangUsaha                          = new ChartOfAccount("Utang Usaha",                      2101,3, kewajiban, "2/2101", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount utangWesel                          = new ChartOfAccount("Utang Wesel",                      2102,3, kewajiban, "2/2102", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount utangBankJatuhTempoKurangDari1Tahun = new ChartOfAccount("Utang Bank(Jatuh Tempo < 1 Tahun)",2103,3, kewajiban, "2/2103", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount utangSewa                           = new ChartOfAccount("Utang Sewa",                       2104,3, kewajiban, "2/2104", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount utangGaji                           = new ChartOfAccount("Utang Gaji",                       2105,3, kewajiban, "2/2105", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaYangMasihHarusDibayar          = new ChartOfAccount("Biaya Yang Masih Harus Dibayar",   2106,3, kewajiban, "2/2106", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount pendapatanDiterimaDimuka            = new ChartOfAccount("Pendapatan Diterima Dimuka",       2107,3, kewajiban, "2/2107", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount utangPajak                          = new ChartOfAccount("Utang Pajak",                      2108,3, kewajiban, "2/2108", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount kewajibanJangkaPanjang              = new ChartOfAccount("Kewajiban Jangka Panjang",         22,  2, kewajiban, "2/22",   NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount utangBankJatuhTempLebihDari1Tahun   = new ChartOfAccount("Utang Bank(Jatuh Tempo > 1 Tahun)",2201,3, kewajiban, "2/2201", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount utangObligasi                       = new ChartOfAccount("Utang Obligasi",                   2202,3, kewajiban, "2/2202", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount utangHipotik                        = new ChartOfAccount("Utang Hipotik",                    2203,3, kewajiban, "2/2203", NormalBalance.DEBIT, Collections.emptyList());

        chartOfAccountRepository.saveAll(List.of(
                kewajiban,
                kewajibanLancar,
                utangUsaha,
                utangWesel,
                utangBankJatuhTempoKurangDari1Tahun,
                utangSewa,
                utangGaji,
                biayaYangMasihHarusDibayar,
                pendapatanDiterimaDimuka,
                utangPajak,
                kewajibanJangkaPanjang,
                utangBankJatuhTempLebihDari1Tahun,
                utangObligasi,
                utangHipotik
        ));
    }

    public void account3() {
        ChartOfAccount modal        = new ChartOfAccount("Modal(Ekuitas)",3,   1,null, "3",      NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount modalPribadi = new ChartOfAccount("Modal Pribadi", 3101,3, modal,     "3/3101", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount prive        = new ChartOfAccount("Prive",         3102,3, modal,     "3/3102", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount modalSaham   = new ChartOfAccount("Modal Saham",   3103,3, modal,     "3/3103", NormalBalance.DEBIT, Collections.emptyList());

        chartOfAccountRepository.saveAll(List.of(
                modal,
                modalPribadi,
                prive,
                modalSaham
        ));
    }

    public void account4() {
        ChartOfAccount pendapatan                 = new ChartOfAccount("Pendapatan",                   4,   1, null,           "4",         NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount pendapatanOperasional      = new ChartOfAccount("Pendapatan Operasional",       41,  2, pendapatan,           "4/41",      NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount penjualan                  = new ChartOfAccount("Penjualan",                    4101,3, pendapatanOperasional,"4/41/4101", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount returPenjualan             = new ChartOfAccount("Retur Penjualan",              4102,3, pendapatanOperasional,"4/41/4102", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount potonganPenjualan          = new ChartOfAccount("Potongan Penjualan",           4103,3, pendapatanOperasional,"4/41/4103", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount pendapatanDiluarUsaha      = new ChartOfAccount("Pendapatan Diluar Usaha",      42,  2, pendapatan,           "4/42",      NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount pendapatanBunga            = new ChartOfAccount("Pendapatan Bunga",             4201,3, pendapatanDiluarUsaha,"4/42/4201", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount labaPenjualanAsetTetap     = new ChartOfAccount("Laba Penjualan Aset Tetap",    4202,3, pendapatanDiluarUsaha,"4/42/4202", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount labaPenjualanSuratBerharga = new ChartOfAccount("laba Penjualan Surat Berharga",4203,3, pendapatanDiluarUsaha,"4/42/4203", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount pendapatanLainnya          = new ChartOfAccount("Pendapatan Lainnya",           4204,3, pendapatanDiluarUsaha,"4/42/4204", NormalBalance.DEBIT, Collections.emptyList());

        chartOfAccountRepository.saveAll(List.of(
                pendapatan,
                pendapatanOperasional,
                penjualan,
                returPenjualan,
                potonganPenjualan,
                pendapatanDiluarUsaha,
                pendapatanBunga,
                labaPenjualanAsetTetap,
                labaPenjualanSuratBerharga,
                pendapatanLainnya
        ));
    }

    public void account5() {
        ChartOfAccount pembelian            = new ChartOfAccount("Pembelian",             5,   1, null,"5",      NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount pembelian1           = new ChartOfAccount("Pembelian",             5101,2, pembelian, "5/5101", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount returPembelian       = new ChartOfAccount("Retur Pembelian",       5102,3, pembelian1,"5/5102", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount potonganPembelian    = new ChartOfAccount("Potongan Pembelian",    5103,3, pembelian1,"5/5103", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount bebanAngkutPembelian = new ChartOfAccount("Beban Angkut Pembelian",5104,3, pembelian1,"5/5104", NormalBalance.DEBIT, Collections.emptyList());

        chartOfAccountRepository.saveAll(List.of(
                pembelian,
                pembelian1,
                returPembelian,
                potonganPembelian,
                bebanAngkutPembelian
        ));
    }

    public void account6() {
        ChartOfAccount biaya                       = new ChartOfAccount("Biaya",                         6,   1, null,                 "6",         NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaOperasional            = new ChartOfAccount("Biaya Operasional",             61,  2, biaya,                      "6/61",      NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaGaji                   = new ChartOfAccount("Biaya Gaji",                    6101,3, biayaOperasional,           "6/61/6101", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaGedung                 = new ChartOfAccount("Biaya Gedung",                  6102,3, biayaOperasional,           "6/61/6102", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaPenyusutanGedung       = new ChartOfAccount("Biaya Penyusutan Gedung",       6103,3, biayaOperasional,           "6/61/6103", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaPenyusutanKendaraan    = new ChartOfAccount("Biaya Penyusutan Kendaraan",    6104,3, biayaOperasional,           "6/61/6104", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaPenyusutanMesin        = new ChartOfAccount("Biaya Penyusutan Mesin",        6105,3, biayaOperasional,           "6/61/6105", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaPenyusutanPeralatan    = new ChartOfAccount("Biaya Penyusutan Peralatan",    6106,3, biayaOperasional,           "6/61/6106", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaAirListrikDanTelepon   = new ChartOfAccount("Biaya Air Listrik dan Telepon", 6107,3, biayaOperasional,           "6/61/6107", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaPerlengkapan           = new ChartOfAccount("Biaya Perlengkapan",            6108,3, biayaOperasional,           "6/61/6108", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaIklan                  = new ChartOfAccount("Biaya Iklan",                   6109,3, biayaOperasional,           "6/61/6109", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount kerugianPiutang             = new ChartOfAccount("Kerugian Piutang",              6110,3, biayaOperasional,           "6/61/6110", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaAsuransi               = new ChartOfAccount("Biaya Asuransi",                6111,3, biayaOperasional,           "6/61/6111", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaLainLain               = new ChartOfAccount("Biaya Lain-lain",               6112,3, biayaOperasional,           "6/61/6112", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaOperasionalDiluarUsaha = new ChartOfAccount("Biaya Operasional Diluar Usaha",62,  2, biaya,                      "6/62",      NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaBunga                  = new ChartOfAccount("Biaya Bunga",                   6201,3, biayaOperasionalDiluarUsaha,"6/62/6201", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount rugiPenjualanAsetTetap      = new ChartOfAccount("Rugi Penjualan Aset Tetap",     6202,3, biayaOperasionalDiluarUsaha,"6/62/6202", NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount rugiPenjualanSuratBerharga  = new ChartOfAccount("Rugi Penjualan Surat Berharga", 6203,3, biayaOperasionalDiluarUsaha,"6/62/6203", NormalBalance.DEBIT, Collections.emptyList());

        chartOfAccountRepository.saveAll(List.of(
                biaya,
                biayaOperasional,
                biayaGaji,
                biayaGedung,
                biayaPenyusutanGedung,
                biayaPenyusutanKendaraan,
                biayaPenyusutanMesin,
                biayaPenyusutanPeralatan,
                biayaAirListrikDanTelepon,
                biayaPerlengkapan,
                biayaIklan,
                kerugianPiutang,
                biayaAsuransi,
                biayaLainLain,
                biayaOperasionalDiluarUsaha,
                biayaBunga,
                rugiPenjualanAsetTetap,
                rugiPenjualanSuratBerharga
        ));
    }
    // @formatter:on
}