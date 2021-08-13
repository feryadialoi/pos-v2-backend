package com.gdi.posbackend.repository;

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
    void countAllByIdIn() {
        List<Long> ids1 = List.of(1L, 2L, 3L);
        long exists1 = unitRepository.existsAllByIdIn(ids1, ids1.size());
        Assertions.assertEquals(1, exists1);

        List<Long> ids2 = List.of(1L, 2L, 20L);
        long exists2 = unitRepository.existsAllByIdIn(ids2, ids2.size());
        Assertions.assertEquals(0, exists2);
    }

}