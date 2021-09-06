package com.gdi.posbackend.db.seed;

import com.gdi.posbackend.entity.RunningNumber;
import com.gdi.posbackend.repository.RunningNumberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 7/30/2021 11:01 AM
 */
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class SeedRunningNumber {

    private final RunningNumberRepository runningNumberRepository;

    public void seed() {
        long count = runningNumberRepository.countByPrefixIn(List.of("SO", "PO", "S", "P", "DO", "SP", "BP", "SA"));

        if (count == 0) {
            RunningNumber runningNumber1 = new RunningNumber("SO", "Sale Order", 0);
            RunningNumber runningNumber2 = new RunningNumber("S", "Sale", 0);
            RunningNumber runningNumber3 = new RunningNumber("PO", "Purchase Order", 0);
            RunningNumber runningNumber4 = new RunningNumber("P", "Purchase", 0);
            RunningNumber runningNumber5 = new RunningNumber("DO", "Delivery Order", 0);
            RunningNumber runningNumber6 = new RunningNumber("SP", "Supplier", 0);
            RunningNumber runningNumber7 = new RunningNumber("BP", "Batch of Product", 0);
            RunningNumber runningNumber8 = new RunningNumber("SA", "Stock Adjustment", 0);

            runningNumberRepository.saveAll(Arrays.asList(
                    runningNumber1,
                    runningNumber2,
                    runningNumber3,
                    runningNumber4,
                    runningNumber5,
                    runningNumber6,
                    runningNumber7,
                    runningNumber8
            ));
            log.info("running number seed success");
        } else {
            log.info("no need to seed running number");
        }

    }
}
