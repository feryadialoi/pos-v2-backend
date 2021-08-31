package com.gdi.posbackend.repository;

import com.gdi.posbackend.constant.SettingNameOfCompanySetting;
import com.gdi.posbackend.entity.ChartOfAccount;
import com.gdi.posbackend.entity.projection.chartofaccount.ChartOfAccountCountByLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Feryadialoi
 * @date 8/19/2021 2:02 AM
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChartOfAccountRepositoryTest {

    @Autowired
    private ChartOfAccountRepository chartOfAccountRepository;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testInsert() {


    }

    @Test
    void testGetData() {
        List<ChartOfAccount> coas = chartOfAccountRepository.findAll(Sort.by("path"));
        coas.forEach(System.out::println);
    }

    @Test
    void testGetCoaLevelGroupByLevel() {
        List<ChartOfAccountCountByLevel> coaLevelGroupByLevel = chartOfAccountRepository.findAllCoaLevelGroupByLevel();
        coaLevelGroupByLevel.forEach(chartOfAccountCountByLevel -> {
            System.out.println("level       : " + chartOfAccountCountByLevel.getLevel());
            System.out.println("levelCount  : " + chartOfAccountCountByLevel.getLevelCount());
            System.out.println("==================");
        });
    }

    @Test
    void testFindOneCoaLevelGroupByLevelByLevel() {
        ChartOfAccountCountByLevel oneCoaLevelGroupByLevelByLevel1 = chartOfAccountRepository.findOneCoaLevelGroupByLevelByLevel(1);
        System.out.println("level       : " + oneCoaLevelGroupByLevelByLevel1.getLevel());
        System.out.println("levelCount  : " + oneCoaLevelGroupByLevelByLevel1.getLevelCount());
        System.out.println("==================");

        ChartOfAccountCountByLevel oneCoaLevelGroupByLevelByLevel2 = chartOfAccountRepository.findOneCoaLevelGroupByLevelByLevel(1);
        System.out.println("level       : " + oneCoaLevelGroupByLevelByLevel2.getLevel());
        System.out.println("levelCount  : " + oneCoaLevelGroupByLevelByLevel2.getLevelCount());
        System.out.println("==================");

        ChartOfAccountCountByLevel oneCoaLevelGroupByLevelByLevel3 = chartOfAccountRepository.findOneCoaLevelGroupByLevelByLevel(1);
        System.out.println("level       : " + oneCoaLevelGroupByLevelByLevel3.getLevel());
        System.out.println("levelCount  : " + oneCoaLevelGroupByLevelByLevel3.getLevelCount());
        System.out.println("==================");
    }

    @Test
    void testFindOneCoaCountByLevel_withNotExistLevel() {
        ChartOfAccountCountByLevel chartOfAccountCountByLevel = chartOfAccountRepository.findOneCoaLevelGroupByLevelByLevel(4);
        Assertions.assertNull(chartOfAccountCountByLevel);
    }

    @Test
    void testFindByCompanySetting() {
        chartOfAccountRepository.findByCompanySetting(SettingNameOfCompanySetting.COA_PURCHASE.name())
                .ifPresentOrElse(
                        (chartOfAccount) -> System.out.println(chartOfAccount),
                        () -> System.out.println("not found")
                );

    }
}