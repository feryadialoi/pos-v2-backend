package com.gdi.posbackend.util;

import com.gdi.posbackend.entity.RunningNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Feryadialoi
 * @date 7/30/2021 11:05 AM
 */
@Slf4j
@Component
public class RunningNumberCodeUtil {

    /**
     * code format = PP-YYYY-MM-XXXXX
     * e.g. SO-2021-07-00001
     *
     * @param number
     * @return String
     */
    public String getFormattedCode(RunningNumber number) {
        return getFormattedCode(number, LocalDateTime.now());
    }

    public String getFormattedCode(RunningNumber number, LocalDateTime time) {

        String paddedNumber = String.format("%5s", number.getNumber()).replace(' ', '0');

        String paddedMonth = String.format("%2s", time.getMonthValue()).replace(' ', '0');

        return number.getPrefix() + "-" + time.getYear() + "-" + paddedMonth + "-" + paddedNumber;
    }
}
