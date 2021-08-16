package com.gdi.posbackend.util;

import com.gdi.posbackend.entity.RunningNumber;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @author Feryadialoi
 * @date 7/30/2021 11:20 AM
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RunningNumberCodeUtilTest {

    @Autowired
    private RunningNumberCodeUtil runningNumberCodeUtil;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test() {
        RunningNumber runningNumberSO = new RunningNumber("SO", "Sale Order", 0);
        RunningNumber runningNumberS = new RunningNumber("S", "Sale", 0);
        RunningNumber runningNumberPO = new RunningNumber("PO", "Purchase Order", 0);
        RunningNumber runningNumberP = new RunningNumber("P", "Purchase", 0);
        RunningNumber runningNumberDO = new RunningNumber("DO", "Delivery Order", 0);

        LocalDateTime time = LocalDateTime.of(2021, 7, 1, 0, 0);

        String codeSO = runningNumberCodeUtil.getFormattedCode(runningNumberSO, time);
        String codeS = runningNumberCodeUtil.getFormattedCode(runningNumberS, time);
        String codePO = runningNumberCodeUtil.getFormattedCode(runningNumberPO, time);
        String codeP = runningNumberCodeUtil.getFormattedCode(runningNumberP, time);
        String codeDO = runningNumberCodeUtil.getFormattedCode(runningNumberDO, time);

        log.info(codeSO);
        log.info(codeS);
        log.info(codePO);
        log.info(codeP);
        log.info(codeDO);

        Assertions.assertEquals("SO-2021-07-00001", codeSO);
        Assertions.assertEquals("S-2021-07-00001", codeS);
        Assertions.assertEquals("PO-2021-07-00001", codePO);
        Assertions.assertEquals("P-2021-07-00001", codeP);
        Assertions.assertEquals("DO-2021-07-00001", codeDO);
    }
}