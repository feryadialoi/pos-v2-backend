package com.gdi.posbackend.scheduler;

import com.gdi.posbackend.repository.RunningNumberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Feryadialoi
 * @date 8/2/2021 9:40 PM
 */
@Slf4j
@Transactional
@Component
@AllArgsConstructor
public class RunningNumberResetSchedulerTask {

    private final RunningNumberRepository runningNumberRepository;


    /**
     * reset all of the running number to zero
     * at 00:00 on first day of every month
     * TODO create testing, untested
     */
    @Scheduled(cron = "0 0 1 * * *")
    public void resetRunningNumber() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        log.info("Running number reset start at {}", LocalDateTime.now().format(formatter));
        runningNumberRepository.resetRunningNumber();
        log.info("Running number reset done at {}", LocalDateTime.now().format(formatter));
    }
}
