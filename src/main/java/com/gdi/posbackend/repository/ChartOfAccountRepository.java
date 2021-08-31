package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.ChartOfAccount;
import com.gdi.posbackend.entity.projection.chartofaccount.ChartOfAccountCountByLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/19/2021 2:01 AM
 */
public interface ChartOfAccountRepository extends JpaRepository<ChartOfAccount, String>, JpaSpecificationExecutor<ChartOfAccount> {

    @Query(
            value = "SELECT c.level, COUNT(c.level) as levelCount " +
                    "FROM chart_of_accounts as c GROUP BY level ORDER BY level",
            nativeQuery = true
    )
    List<ChartOfAccountCountByLevel> findAllCoaLevelGroupByLevel();

    @Query(
            value = "SELECT level, levelCount FROM (" +
                    "SELECT c.level, COUNT(c.level) as levelCount FROM chart_of_accounts as c GROUP BY level ORDER BY level" +
                    ") as coasGroupByLevel WHERE level = :level",
            nativeQuery = true
    )
    ChartOfAccountCountByLevel findOneCoaLevelGroupByLevelByLevel(@Param("level") Integer level);

    Optional<ChartOfAccount> findByName(String name);

    Optional<ChartOfAccount> findByAccountCode(Integer accountCode);

    @Query(
            value = "SELECT coa FROM ChartOfAccount coa WHERE coa.id = (SELECT cs.settingValue FROM CompanySetting cs WHERE cs.settingName = :settingNameOfCompanySetting)"
    )
    Optional<ChartOfAccount> findByCompanySetting(String settingNameOfCompanySetting);
}
