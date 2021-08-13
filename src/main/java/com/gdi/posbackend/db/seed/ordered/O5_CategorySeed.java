package com.gdi.posbackend.db.seed.ordered;

import com.gdi.posbackend.entity.Category;
import com.gdi.posbackend.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/5/2021 11:04 AM
 */
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class O5_CategorySeed implements ApplicationListener<ApplicationReadyEvent>, Ordered {

    private final CategoryRepository categoryRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Optional<Category> optional = categoryRepository.findByNameIgnoreCase("Makanan");
        if (optional.isEmpty()) {
            insertData();
            log.info("seed data category success");
        } else {
            log.info("no need to seed category data");
        }
    }

    private void insertData() {
        Category category = new Category();
        category.setName("Makanan");
        categoryRepository.save(category);
    }

    @Override
    public int getOrder() {
        return 5;
    }
}
