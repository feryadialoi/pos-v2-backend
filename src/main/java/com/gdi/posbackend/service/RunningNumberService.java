package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.RunningNumber;
import com.gdi.posbackend.entity.enums.RunningNumberPrefix;

/**
 * @author Feryadialoi
 * @date 8/16/2021 12:14 PM
 */
public interface RunningNumberService {
    RunningNumber getRunningNumber(RunningNumberPrefix runningNumberPrefix);
}
