package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.RunningNumber;
import com.gdi.posbackend.entity.enums.RunningNumberPrefix;
import com.gdi.posbackend.repository.RunningNumberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/30/2021 1:58 PM
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RunningNumberServiceTest {

    @Autowired
    private RunningNumberRepository runningNumberRepository;

    @Test
    void insertRunningNumberOfBatchOfProduct() {
        long count = runningNumberRepository.countByPrefixIn(List.of(RunningNumberPrefix.BP.name()));
        if (count == 0) {
            RunningNumber runningNumber = new RunningNumber();
            runningNumber.setPrefix(RunningNumberPrefix.BP.name());
            runningNumber.setNumber(0);
            runningNumber.setDescription("Batch of Product");

            runningNumber = runningNumberRepository.save(runningNumber);
            log.info("running number id           : {} ", runningNumber.getId());
            log.info("running number prefix       : {} ", runningNumber.getPrefix());
            log.info("running number number       : {} ", runningNumber.getNumber());
            log.info("running number description  : {} ", runningNumber.getDescription());

            Assertions.assertNotNull(runningNumber.getId());
        }

    }

    @Test
    void insertRunningNumberOfStockAdjustment() {
        long count = runningNumberRepository.countByPrefixIn(List.of(RunningNumberPrefix.SA.name()));
        if (count == 0) {
            RunningNumber runningNumber = new RunningNumber();
            runningNumber.setPrefix(RunningNumberPrefix.SA.name());
            runningNumber.setNumber(0);
            runningNumber.setDescription("Stock Adjustment");

            runningNumber = runningNumberRepository.save(runningNumber);
            log.info("running number id           : {} ", runningNumber.getId());
            log.info("running number prefix       : {} ", runningNumber.getPrefix());
            log.info("running number number       : {} ", runningNumber.getNumber());
            log.info("running number description  : {} ", runningNumber.getDescription());

            Assertions.assertNotNull(runningNumber.getId());
        }

    }
}
