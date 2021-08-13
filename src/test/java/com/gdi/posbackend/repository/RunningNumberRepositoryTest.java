package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.RunningNumber;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Feryadialoi
 * @date 8/5/2021 1:22 AM
 */
@Slf4j
@SpringBootTest
class RunningNumberRepositoryTest {

    @Autowired
    private RunningNumberRepository runningNumberRepository;

    @Test
    void findByPrefix() {
        RunningNumber runningNumber = runningNumberRepository.findByPrefix("SO");
        Assertions.assertNotNull(runningNumber);
    }

    @Test
    void resetRunningNumber() {
        runningNumberRepository.resetRunningNumber();
        List<RunningNumber> runningNumbers = runningNumberRepository.findAll();
        long count = runningNumberRepository.countByNumberIsGreaterThan(0);
        log.info("countByNumberIsGreaterThan {}", count);
        Assertions.assertEquals(0, count);
    }

    @Test
    void countByPrefixIn() {
        long count = runningNumberRepository.countByPrefixIn(List.of("SO", "PO", "S", "P", "DO"));
        log.info(String.valueOf(count));
    }
}