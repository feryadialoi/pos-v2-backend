package com.gdi.posbackend.db.seed;

import com.gdi.posbackend.entity.BaseEntity;
import com.gdi.posbackend.entity.CompanySetting;
import com.gdi.posbackend.entity.enums.CompanySettingCategory;
import com.gdi.posbackend.entity.enums.CompanySettingValueType;
import com.gdi.posbackend.exception.ChartOfAccountNotFoundException;
import com.gdi.posbackend.repository.ChartOfAccountRepository;
import com.gdi.posbackend.repository.CompanySettingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/25/2021 11:08 AM
 */
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class SeedCompanySetting {

    private final CompanySettingRepository companySettingRepository;
    private final ChartOfAccountRepository chartOfAccountRepository;

    /**
     * `satuan` varchar(255),
     * `accounting` varchar(255),
     * `hpp` varchar(255),
     * `tax` varchar(255),
     * `tax_rate` double,
     * `coa_penjualan` varchar(255),
     * `coa_pembelian` varchar(255),
     * `coa_hutang` varchar(255),
     * `coa_piutang` varchar(255),
     * `coa_pajak` varchar(255),
     * `coa_pajak_out` varchar(255),
     * `coa_discount` varchar(255),
     * `coa_discount_buy` varchar(255),
     * `coa_ikhtisar_labarugi` varchar(255),
     * `coa_labarugi_ditahan` varchar(255)
     */

    public void seed() {
        if (companySettingRepository.count() == 0) {
            seedMiscellaneousSetting();
            seedChartOfAccount();
        }
    }

    private void seedMiscellaneousSetting() {
        CompanySetting companySettingUnit = CompanySetting.builder()
                .displayName("Satuan")
                .settingName("UNIT")
                .settingValue(null)
                .settingValueType(CompanySettingValueType.STRING)
                .settingDescription("")
                .category(CompanySettingCategory.GENERAL)
                .build();

        CompanySetting companySettingAccounting = CompanySetting.builder()
                .displayName("Akuntansi")
                .settingName("ACCOUNTING")
                .settingValue(null)
                .settingValueType(CompanySettingValueType.STRING)
                .settingDescription("")
                .category(CompanySettingCategory.GENERAL)
                .build();

        CompanySetting companySettingCOGS = CompanySetting.builder()
                .displayName("Harga Pokok Penjualan")
                .settingName("COGS")
                .settingValue(null)
                .settingValueType(CompanySettingValueType.STRING)
                .settingDescription("")
                .category(CompanySettingCategory.GENERAL)
                .build();

        CompanySetting companySettingIsTaxed = CompanySetting.builder()
                .displayName("Dipajakan")
                .settingName("IS_TAXED")
                .settingValue("true")
                .settingValueType(CompanySettingValueType.BOOLEAN)
                .settingDescription("")
                .category(CompanySettingCategory.GENERAL)
                .build();

        CompanySetting companySettingTaxRate = CompanySetting.builder()
                .displayName("Besaran Pajak")
                .settingName("TAX_RATE")
                .settingValue("10")
                .settingValueType(CompanySettingValueType.BIG_DECIMAL)
                .settingDescription("")
                .category(CompanySettingCategory.GENERAL)
                .build();

        companySettingRepository.saveAll(List.of(
                companySettingUnit,
                companySettingAccounting,
                companySettingCOGS,
                companySettingIsTaxed,
                companySettingTaxRate
        ));

    }

    private void seedChartOfAccount() {
        CompanySetting companySettingCoaSale = CompanySetting.builder()
                .displayName("Kode Akun Penjualan")
                .settingName("COA_SALE")
                .settingValue(getChartOfAccount(4101))
                .settingValueType(CompanySettingValueType.STRING)
                .settingDescription("")
                .category(CompanySettingCategory.CHART_OF_ACCOUNT)
                .build();

        CompanySetting companySettingCoaPurchase = CompanySetting.builder()
                .displayName("Kode Akun Pembelian")
                .settingName("COA_PURCHASE")
                .settingValue(getChartOfAccount(5101))
                .settingValueType(CompanySettingValueType.STRING)
                .settingDescription("")
                .category(CompanySettingCategory.CHART_OF_ACCOUNT)
                .build();

        CompanySetting companySettingCoaPayable = CompanySetting.builder()
                .displayName("Kode Akun Utang")
                .settingName("COA_PAYABLE")
                .settingValue(getChartOfAccount(4101))
                .settingValueType(CompanySettingValueType.STRING)
                .settingDescription("")
                .category(CompanySettingCategory.CHART_OF_ACCOUNT)
                .build();

        CompanySetting companySettingCoaReceivable = CompanySetting.builder()
                .displayName("Kode Akun Piutang")
                .settingName("COA_RECEIVABLE")
                .settingValue(getChartOfAccount(1104))
                .settingValueType(CompanySettingValueType.STRING)
                .settingDescription("")
                .category(CompanySettingCategory.CHART_OF_ACCOUNT)
                .build();

        CompanySetting companySettingCoaTaxIn = CompanySetting.builder()
                .displayName("Kode Akun Pajak Masukan")
                .settingName("COA_TAX_IN")
                .settingValue(null)
                .settingValueType(CompanySettingValueType.STRING)
                .settingDescription("")
                .category(CompanySettingCategory.CHART_OF_ACCOUNT)
                .build();

        CompanySetting companySettingCoaTaxOut = CompanySetting.builder()
                .displayName("Kode Akun Pajak Keluaran")
                .settingName("COA_TAX_OUT")
                .settingValue(null)
                .settingValueType(CompanySettingValueType.STRING)
                .settingDescription("")
                .category(CompanySettingCategory.CHART_OF_ACCOUNT)
                .build();

        CompanySetting companySettingCoaDiscountIn = CompanySetting.builder()
                .displayName("Kode Akun Diskon Masukan")
                .settingName("COA_DISCOUNT_IN")
                .settingValue(null)
                .settingValueType(CompanySettingValueType.STRING)
                .settingDescription("")
                .category(CompanySettingCategory.CHART_OF_ACCOUNT)
                .build();

        CompanySetting companySettingCoaDiscountOut = CompanySetting.builder()
                .displayName("Kode Akun Diskon Keluaran")
                .settingName("COA_DISCOUNT_OUT")
                .settingValue(null)
                .settingValueType(CompanySettingValueType.STRING)
                .settingDescription("")
                .category(CompanySettingCategory.CHART_OF_ACCOUNT)
                .build();

        CompanySetting companySettingCoaIncomeSummary = CompanySetting.builder()
                .displayName("Kode Akun Ikhtisiar Labarugi")
                .settingName("COA_INCOME_SUMMARY")
                .settingValue(null)
                .settingValueType(CompanySettingValueType.STRING)
                .settingDescription("")
                .category(CompanySettingCategory.CHART_OF_ACCOUNT)
                .build();

        CompanySetting companySettingCoaRetainedEarning = CompanySetting.builder()
                .displayName("Kode Akun Laba Rugi Tertahan")
                .settingName("COA_RETAINED_EARNING")
                .settingValue(null)
                .settingValueType(CompanySettingValueType.STRING)
                .settingDescription("")
                .category(CompanySettingCategory.CHART_OF_ACCOUNT)
                .build();

        companySettingRepository.saveAll(List.of(
                companySettingCoaSale,
                companySettingCoaPurchase,
                companySettingCoaPayable,
                companySettingCoaReceivable,
                companySettingCoaTaxIn,
                companySettingCoaTaxOut,
                companySettingCoaDiscountIn,
                companySettingCoaDiscountOut,
                companySettingCoaIncomeSummary,
                companySettingCoaRetainedEarning
        ));
    }

    public String getChartOfAccount(Integer accountCode) {
        return chartOfAccountRepository.findByAccountCode(accountCode)
                .map(BaseEntity::getId)
                .orElseThrow(() -> new ChartOfAccountNotFoundException("chart of account not found"));
    }
}
