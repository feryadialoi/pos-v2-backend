package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.RunningNumber;
import com.gdi.posbackend.entity.enums.RunningNumberPrefix;
import com.gdi.posbackend.repository.RunningNumberRepository;
import com.gdi.posbackend.service.RunningNumberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/16/2021 12:45 PM
 */
@Service
@Transactional
@AllArgsConstructor
public class RunningNumberServiceImpl implements RunningNumberService {

    private final RunningNumberRepository runningNumberRepository;

    @Override
    public RunningNumber getRunningNumber(RunningNumberPrefix runningNumberPrefix) {

        return runningNumberRepository.findByPrefix(runningNumberPrefix.name())
                .map(runningNumber -> {
                    runningNumber.setNumber(runningNumber.getNumber() + 1);
                    return runningNumberRepository.save(runningNumber);
                })
                .orElseGet(() -> {
                    RunningNumber runningNumber = new RunningNumber();
                    runningNumber.setPrefix(runningNumberPrefix.name());
                    runningNumber.setNumber(1);
                    runningNumber.setDescription(runningNumberPrefix.name());
                    return runningNumberRepository.save(runningNumber);
                });

    }
}
