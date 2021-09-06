package com.gdi.posbackend.db.seed;

import com.gdi.posbackend.constant.SettingNameOfCompanySetting;
import com.gdi.posbackend.entity.BaseEntity;
import com.gdi.posbackend.entity.Company;
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

    public void seed() {
        if (companySettingRepository.count() == 0) {
            seedMiscellaneousSetting();
            seedChartOfAccount();
        }
    }

    private void seedMiscellaneousSetting() {


    }

    // @formatter:off
    private void seedChartOfAccount() {
        Company company = new Company(
                "PT Sumber Pangan Makmur",
                "Jl. Perniagaan No 88",
                "081234567890",
                "Bank Mandiri",
                "Bank Mandiri KCP Perniagaan",
                "1234567890",
                "Rudiantara",
                "Jl. Perniagaan No 88",
                "0987654321"
        );

        CompanySetting companySetting01 = createCompanySetting(company, "Kode Akun Pembelian",          SettingNameOfCompanySetting.COA_PURCHASE,           "");
        CompanySetting companySetting02 = createCompanySetting(company, "Kode Akun Retur Pembelian",    SettingNameOfCompanySetting.COA_PURCHASE_RETURN,    "");
        CompanySetting companySetting03 = createCompanySetting(company, "Kode Akun Potongan Pembelian", SettingNameOfCompanySetting.COA_PURCHASE_DISCOUNT,  "");
        CompanySetting companySetting04 = createCompanySetting(company, "Kode Akun Pajak Pembelian",    SettingNameOfCompanySetting.COA_PURCHASE_TAX,       "");

        CompanySetting companySetting05 = createCompanySetting(company, "Kode Akun Penjualan",          SettingNameOfCompanySetting.COA_SALE,               "" );
        CompanySetting companySetting06 = createCompanySetting(company, "Kode Akun Retur Penjualan",    SettingNameOfCompanySetting.COA_SALE_RETURN,        "" );
        CompanySetting companySetting07 = createCompanySetting(company, "Kode Akun Potongan Penjualan", SettingNameOfCompanySetting.COA_SALE_DISCOUNT,      "" );
        CompanySetting companySetting08 = createCompanySetting(company, "Kode Akun Pajak Penjualan",    SettingNameOfCompanySetting.COA_SALE_TAX,           "" );

        CompanySetting companySetting09 = createCompanySetting(company, "Kode Akun Biaya Lain-lain",    SettingNameOfCompanySetting.COA_OTHER_FEE,          "");

        CompanySetting companySetting10 = createCompanySetting(company, "Kode Akun Piutang",            SettingNameOfCompanySetting.COA_RECEIVABLE,         "");
        CompanySetting companySetting11 = createCompanySetting(company, "Kode Akun Utang",              SettingNameOfCompanySetting.COA_PAYABLE,            "");

    }
    // @formatter:on

    private CompanySetting createCompanySetting(Company company, String displayName, SettingNameOfCompanySetting settingNameOfCompanySetting, String settingDescription) {
        return new CompanySetting(
                company,
                displayName,
                settingNameOfCompanySetting.name(),
                null,
                CompanySettingValueType.STRING,
                CompanySettingCategory.CHART_OF_ACCOUNT,
                settingDescription
        );
    }
}
