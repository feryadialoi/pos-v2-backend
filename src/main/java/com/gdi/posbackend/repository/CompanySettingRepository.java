package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.CompanySetting;
import com.gdi.posbackend.entity.projection.companysetting.CompanySettingWithChartOfAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/20/2021 10:32 AM
 */
public interface CompanySettingRepository extends JpaRepository<CompanySetting, String>, JpaSpecificationExecutor<CompanySetting> {
    @Query(value = "SELECT " +
            "coa.id as chartOfAccountId, " +
            "coa.name as chartOfAccountName, " +
            "coa.account_code as chartOfAccountAccountCode, " +
            "cs.id, " +
            "cs.company_id as companyId, " +
            "cs.display_name as displayName, " +
            "cs.setting_name as settingName, " +
            "cs.setting_value as settingValue, " +
            "cs.setting_value_type as settingValueType, " +
            "cs.category, " +
            "cs.setting_description as settingDescription " +
            "from company_settings as cs " +
            "left join chart_of_accounts as coa " +
            "on cs.setting_value = coa.id " +
            "where cs.category = 'CHART_OF_ACCOUNT'",
            nativeQuery = true)
    List<CompanySettingWithChartOfAccount> findAllCompanySettingOfChartOfAccount();


    @Modifying
    @Query(value = "UPDATE CompanySetting cs SET cs.settingValue = :settingValue WHERE cs.id = :companySettingId")
    int updateSettingValueOfCompanySetting(@Param("companySettingId") String companySettingId, @Param("settingValue") String settingValue);

    Optional<CompanySetting> findBySettingName(String settingName);
}
