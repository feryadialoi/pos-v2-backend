package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.enums.CogsMethod;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Feryadialoi
 * @date 8/30/2021 10:56 AM
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CogsServiceTest {
    @Autowired
    private CogsService cogsService;

    @Test
    void testGetCogsMethod() {
        CogsMethod cogsMethod = cogsService.getCogsMethod();

        log.info(cogsMethod.name());
    }
}
