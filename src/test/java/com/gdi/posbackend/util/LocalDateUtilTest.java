package com.gdi.posbackend.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Feryadialoi
 * @date 7/30/2021 11:40 AM
 */
@Slf4j
class LocalDateUtilTest {

    private LocalDateUtil localDateUtil;

    @BeforeEach
    void setUp() {
        localDateUtil = new LocalDateUtil();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void fromString() {
        LocalDateTime time = localDateUtil.fromString("01-02-2021");

        log.info(time.toString());

        Assertions.assertNotNull(time);

    }
}