package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.projection.companysetting.CompanySettingWithChartOfAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/20/2021 10:34 AM
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CompanySettingRepositoryTest {

    @Autowired
    private CompanySettingRepository companySettingRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testInsertSettings() {

    }

    @Test
    void testGetSettings() {

    }

    @Test
    void testGetCompanySettingWithChartOfAccount() {
        List<CompanySettingWithChartOfAccount> companySettingWithChartOfAccounts = companySettingRepository.findAllCompanySettingOfChartOfAccount();
        System.out.println("companySettingWithChartOfAccounts.size : " + companySettingWithChartOfAccounts.size());
        companySettingWithChartOfAccounts.forEach(companySettingWithChartOfAccount -> {
            System.out.println("==============================================================");
            System.out.println("getId                           : " + companySettingWithChartOfAccount.getId());
            System.out.println("getChartOfAccountId             : " + companySettingWithChartOfAccount.getChartOfAccountId());
            System.out.println("getChartOfAccountName           : " + companySettingWithChartOfAccount.getChartOfAccountName());
            System.out.println("getChartOfAccountAccountCode    : " + companySettingWithChartOfAccount.getChartOfAccountAccountCode());
            System.out.println("getDisplayName                  : " + companySettingWithChartOfAccount.getDisplayName());
            System.out.println("getSettingName                  : " + companySettingWithChartOfAccount.getSettingName());
            System.out.println("getSettingValue                 : " + companySettingWithChartOfAccount.getSettingValue());
            System.out.println("getSettingValueType             : " + companySettingWithChartOfAccount.getSettingValueType());
            System.out.println("getSettingDescription           : " + companySettingWithChartOfAccount.getSettingDescription());
            System.out.println("getCategory                     : " + companySettingWithChartOfAccount.getCategory());
            System.out.println("==============================================================");
        });
    }
}