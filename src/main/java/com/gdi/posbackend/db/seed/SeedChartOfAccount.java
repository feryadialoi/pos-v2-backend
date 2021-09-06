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
            seedChartOfAccount();
        }
    }

    public void seedChartOfAccount() {
        ChartOfAccount aset                                 = new ChartOfAccount( "Aset",                                 1,      1,null,"1",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount asetLancar                           = new ChartOfAccount( "Aset Lancar",                          11,     2,aset,"1/11",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount kasKecil                             = new ChartOfAccount( "Kas Kecil",                            1101,   3,asetLancar,"1/11/1101",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount kasBesar                             = new ChartOfAccount( "Kas Besar",                            1102,   3,asetLancar,"1/11/1102",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount kasBank                              = new ChartOfAccount( "Kas Bank",                             1103,   3,asetLancar,"1/11/1103",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount persediaanBarangDagang               = new ChartOfAccount( "Persediaan Barang Dagang",             1104,   3,asetLancar,"1/11/1104",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount piutangUsaha                         = new ChartOfAccount( "Piutang Usaha",                        1105,   3,asetLancar,"1/11/1105",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount weselTagih                           = new ChartOfAccount( "Wesel Tagih",                          1106,   3,asetLancar,"1/11/1106",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount perlengkapan                         = new ChartOfAccount( "Perlengkapan",                         1107,   3,asetLancar,"1/11/1107",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount sewaDibayarDimuka                    = new ChartOfAccount( "Sewa Dibayar Dimuka",                  1108,   3,asetLancar,"1/11/1108",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount iklanDibayarDimuka                   = new ChartOfAccount( "Iklan Dibayar Dimuka",                 1109,   3,asetLancar,"1/11/1109",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount asuransi_dibayar_dimuka              = new ChartOfAccount( "Asuransi Dibayar Dimuka",              1110,   3,asetLancar,"1/11/1110",NormalBalance.DEBIT, Collections.emptyList());

        ChartOfAccount asetTetap                            = new ChartOfAccount( "Aset Tetap",                           12,     2,aset,"1/12",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount peralatan                            = new ChartOfAccount( "Peralatan",                            1201,   3,asetTetap,"1/12/1201",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount akumulasiPenyusutanPeralatan         = new ChartOfAccount( "Akumulasi Penyusutan Peralatan",       1202,   3,asetTetap,"1/12/1202",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount kendaraan                            = new ChartOfAccount( "Kendaraan",                            1203,   3,asetTetap,"1/12/1203",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount akumulasiPenyusutanKendaraan         = new ChartOfAccount( "Akumulasi Penyusutan Kendaraan",       1024,   3,asetTetap,"1/12/1024",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount gedung                               = new ChartOfAccount( "Gedung",                               1205,   3,asetTetap,"1/12/1205",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount akumulasiPenyusutanGedung            = new ChartOfAccount( "Akumulasi Penyusutan Gedung",          1206,   3,asetTetap,"1/12/1206",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount tanah                                = new ChartOfAccount( "Tanah",                                1207,   3,asetTetap,"1/12/1207",NormalBalance.DEBIT, Collections.emptyList());

        ChartOfAccount kewajiban                            = new ChartOfAccount( "Kewajiban",                            2,      1,null,"2",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount kewajibanLancar                      = new ChartOfAccount( "Kewajiban Lancar",                     21,     2,kewajiban,"2/21",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount utangUsaha                           = new ChartOfAccount( "Utang Usaha",                          2101,   3,kewajibanLancar,"2/21/2101",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount utangWesel                           = new ChartOfAccount( "Utang Wesel",                          2102,   3,kewajibanLancar,"2/21/2102",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount utangBankKurangDari1Tahun            = new ChartOfAccount( "Utang Bank (<1 Tahun)",                2103,   3,kewajibanLancar,"2/21/2103",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount utangSewa                            = new ChartOfAccount( "Utang Sewa",                           2104,   3,kewajibanLancar,"2/21/2104",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount utangGaji                            = new ChartOfAccount( "Utang Gaji",                           2105,   3,kewajibanLancar,"2/21/2105",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount biayaYangMasihHarusDibayar           = new ChartOfAccount( "Biaya Yang Masih Harus Dibayar",       2106,   3,kewajibanLancar,"2/21/2106",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount pendapatanDibayarDimuka              = new ChartOfAccount( "Pendapatan Dibayar Dimuka",            2107,   3,kewajibanLancar,"2/21/2107",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount utangPajak                           = new ChartOfAccount( "Utang Pajak",                          2108,   3,kewajibanLancar,"2/21/2108",NormalBalance.CREDIT, Collections.emptyList());

        ChartOfAccount kewajibanJangkaPanjang               = new ChartOfAccount( "Kewajiban Jangka Panjang",             22,     2,kewajiban,"2/22",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount utangBankLebihDari1Tahun             = new ChartOfAccount( "Utang Bank (>1 Tahun)",                2201,   3,kewajibanJangkaPanjang,"2/22/2201",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount utangObligasi                        = new ChartOfAccount( "Utang Obligasi",                       2202,   3,kewajibanJangkaPanjang,"2/22/2202",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount utangHipotik                         = new ChartOfAccount( "Utang Hipotik",                        2203,   3,kewajibanJangkaPanjang,"2/22/2203",NormalBalance.CREDIT, Collections.emptyList());

        ChartOfAccount modal                                = new ChartOfAccount( "Modal",                                3,      1,null,"3",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount modalPemilik                         = new ChartOfAccount( "Modal Pemilik",                        3001,   3,modal,"3/3001",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount modalSaham                           = new ChartOfAccount( "Modal Saham",                          3002,   3,modal,"3/3002",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount prive                                = new ChartOfAccount( "Prive",                                3003,   3,modal,"3/3003",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount ikhtisarLabaRugi                     = new ChartOfAccount( "Ikhtisar Laba Rugi",                   3004,   3,modal,"3/3004",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount labaRugiDitahan                      = new ChartOfAccount( "Laba Rugi Ditahan",                    3005,   3,modal,"3/3005",NormalBalance.DEBIT, Collections.emptyList());

        ChartOfAccount pendapatan                           = new ChartOfAccount( "Pendapatan",                           4,      1,null,"4",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount pendapatanUsaha                      = new ChartOfAccount( "Pendapatan Usaha",                     41,     2,pendapatan,"4/41",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount penjualan                            = new ChartOfAccount( "Penjualan",                            4101,   3,pendapatanUsaha,"4/41/4101",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount returPenjualan                       = new ChartOfAccount( "Retur Penjualan",                      4102,   3,pendapatanUsaha,"4/41/4102",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount potonganPenjualan                    = new ChartOfAccount( "Potongan Penjualan",                   4103,   3,pendapatanUsaha,"4/41/4103",NormalBalance.DEBIT, Collections.emptyList());

        ChartOfAccount pendapatanDiluarUsaha                = new ChartOfAccount( "Pendapatan Diluar Usaha,",             42,     2,pendapatan,"4/42",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount pendapatanBunga                      = new ChartOfAccount( "Pendapatan Bunga",                     4201,   3,pendapatanDiluarUsaha,"4/42/4201",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount penjualanAsetTetap                   = new ChartOfAccount( "Laba Penjualan Aset Tetap",            4202,   3,pendapatanDiluarUsaha,"4/42/4202",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount labaPenjualanSuratBerharga           = new ChartOfAccount( "Laba Penjualan Surat Berharga",        4203,   3,pendapatanDiluarUsaha,"4/42/4203",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount pendapatanLainnya                    = new ChartOfAccount( "Pendapatan Lainnya",                   4204,   3,pendapatanDiluarUsaha,"4/42/4204",NormalBalance.CREDIT, Collections.emptyList());

        ChartOfAccount pembelian                            = new ChartOfAccount( "Pembelian",                            5,      1,null,"5",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount pembelian1                           = new ChartOfAccount( "Pembelian",                            5001,   3,pembelian,"5/5001",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount returPembelian                       = new ChartOfAccount( "Retur Pembelian",                      5002,   3,pembelian1,"5/5002",NormalBalance.CREDIT, Collections.emptyList());
        ChartOfAccount potonganPembelian                    = new ChartOfAccount( "Potongan Pembelian",                   5003,   3,pembelian1,"5/5003",NormalBalance.CREDIT, Collections.emptyList());

        ChartOfAccount biaya                                = new ChartOfAccount( "Biaya",                                6,      1,null,      "6",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaUsaha                           = new ChartOfAccount( "Biaya Usaha",                          61,     2,biaya,"6/61",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaGaji                            = new ChartOfAccount( "Biaya Gaji",                           6101,   3,biayaUsaha,"6/61/6101",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaSewa                            = new ChartOfAccount( "Biaya Sewa",                           6102,   3,biayaUsaha,"6/61/6102",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaIklan                           = new ChartOfAccount( "Biaya Iklan",                          6103,   3,biayaUsaha,"6/61/6103",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaAsuransi                        = new ChartOfAccount( "Biaya Asuransi",                       6104,   3,biayaUsaha,"6/61/6104",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaPerlengkapan                    = new ChartOfAccount( "Biaya Perlengkapan",                   6105,   3,biayaUsaha,"6/61/6105",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaListrikAirDanTelepon            = new ChartOfAccount( "Biaya Listrik Air Dan Telepon",        6106,   3,biayaUsaha,"6/61/6106",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaAngkutPembelian                 = new ChartOfAccount( "Biaya Angkut Pembelian",               6107,   3,biayaUsaha,"6/61/6107",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount kerugianPiutang                      = new ChartOfAccount( "Kerugian Piutang",                     6108,   3,biayaUsaha,"6/61/6108",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaLainLain                        = new ChartOfAccount( "Biaya Lain-Lain",                      6109,   3,biayaUsaha,"6/61/6109",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaAkumulasiPenyusutanPeralatan    = new ChartOfAccount( "Biaya Akumulasi Penyusutan Peralatan", 6110,   3,biayaUsaha,"6/61/6110",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaAkumulasiPenyusutanKendaraan    = new ChartOfAccount( "Biaya Akumulasi Penyusutan Kendaraan", 6111,   3,biayaUsaha,"6/61/6111",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaAkumulasiPenyusutanGedung       = new ChartOfAccount( "Biaya Akumulasi Penyusutan Gedung",    6112,   3,biayaUsaha,"6/61/6112",NormalBalance.DEBIT, Collections.emptyList());

        ChartOfAccount biayaDiluarUsaha                     = new ChartOfAccount( "Biaya Diluar Usaha,",                  62,     2,biaya,"6/62",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount biayaBunga                           = new ChartOfAccount( "Biaya Bunga",                          6201,   3,biayaDiluarUsaha,"6/62/6201",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount rugiPenjualanAsetTetap               = new ChartOfAccount( "Rugi Penjualan Aset Tetap",            6202,   3,biayaDiluarUsaha,"6/62/6202",NormalBalance.DEBIT, Collections.emptyList());
        ChartOfAccount rugiPenjualanSuratBerharga           = new ChartOfAccount( "Rugi Penjualan Surat Berharga",        6203,   3,biayaDiluarUsaha,"6/62/6203",NormalBalance.DEBIT, Collections.emptyList());

        chartOfAccountRepository.saveAll(List.of(
                aset,
                asetLancar,
                kasKecil,
                kasBesar,
                kasBank,
                persediaanBarangDagang,
                piutangUsaha,
                weselTagih,
                perlengkapan,
                sewaDibayarDimuka,
                iklanDibayarDimuka,
                asuransi_dibayar_dimuka,
                asetTetap,
                peralatan,
                akumulasiPenyusutanPeralatan,
                kendaraan,
                akumulasiPenyusutanKendaraan,
                gedung,
                akumulasiPenyusutanGedung,
                tanah,
                kewajiban,
                kewajibanLancar,
                utangUsaha,
                utangWesel,
                utangBankKurangDari1Tahun,
                utangSewa,
                utangGaji,
                biayaYangMasihHarusDibayar,
                pendapatanDibayarDimuka,
                utangPajak,
                kewajibanJangkaPanjang,
                utangBankLebihDari1Tahun,
                utangObligasi,
                utangHipotik,
                modal,
                modalPemilik,
                modalSaham,
                prive,
                ikhtisarLabaRugi,
                labaRugiDitahan,
                pendapatan,
                pendapatanUsaha,
                penjualan,
                returPenjualan,
                potonganPenjualan,
                pendapatanDiluarUsaha,
                pendapatanBunga,
                penjualanAsetTetap,
                labaPenjualanSuratBerharga,
                pendapatanLainnya,
                pembelian,
                pembelian1,
                returPembelian,
                potonganPembelian,
                biaya,
                biayaUsaha,
                biayaGaji,
                biayaSewa,
                biayaIklan,
                biayaAsuransi,
                biayaPerlengkapan,
                biayaListrikAirDanTelepon,
                kerugianPiutang,
                biayaLainLain,
                biayaAkumulasiPenyusutanPeralatan,
                biayaAkumulasiPenyusutanKendaraan,
                biayaAkumulasiPenyusutanGedung,
                biayaDiluarUsaha,
                biayaBunga,
                rugiPenjualanAsetTetap,
                rugiPenjualanSuratBerharga
        ));

    }
    // @formatter:on
}