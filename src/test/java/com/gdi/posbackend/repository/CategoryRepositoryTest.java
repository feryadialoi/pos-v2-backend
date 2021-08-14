package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/5/2021 2:42 PM
 */
@Slf4j
@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByNameIgnoreCase() {
        Optional<Category> makanan = categoryRepository.findByName("Makanan");
        Assertions.assertTrue(makanan.isPresent());
        Category category = makanan.get();
        log.info("id            = {}", category.getId());
        log.info("name          = {}", category.getName());
        log.info("createdDate   = {}", category.getCreatedDate());
    }
}