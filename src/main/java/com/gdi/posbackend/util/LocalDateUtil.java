package com.gdi.posbackend.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Feryadialoi
 * @date 7/16/2021 3:22 PM
 */
@Component
public class LocalDateUtil {

    /**
     * @param dateString format = DD-MM-YYYY e.g. 01-02-2021
     * @return LocalDateTime
     */
    public LocalDateTime fromString(String dateString) {
        // "02 - 02 - 2020"
        // "01 2 34 5 6789"

        int day = Integer.parseInt(dateString.substring(0, 2));
        int month = Integer.parseInt(dateString.substring(3, 5));
        int year = Integer.parseInt(dateString.substring(6, 10));

        System.out.println(day);
        System.out.println(month);
        System.out.println(year);

        return LocalDateTime.of(year, month, day, 0, 0);
    }
}
