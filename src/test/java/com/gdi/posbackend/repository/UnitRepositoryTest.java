package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Unit;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Feryadialoi
 * @date 8/5/2021 11:57 AM
 */
@SpringBootTest
class UnitRepositoryTest {

    @Autowired
    private UnitRepository unitRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Disabled
    void findByNameLike() {
    }

    @Test
    @Disabled
    void findByNameIgnoreCase() {

    }

    @Test
    @Disabled
    void countByNameInIgnoreCase() {
        long count = unitRepository.countByNameInIgnoreCase(List.of("Kotak", "Pcs"));
        Assertions.assertEquals(2, count);
    }

    @Test
    void testInsertMany() {
        unitRepository.saveAll(List.of(
                new Unit("Pack"),
                new Unit("Pcs")
        ));
    }

}