package com.gdi.posbackend.db.seed.ordered;

import com.gdi.posbackend.entity.Unit;
import com.gdi.posbackend.repository.UnitRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/5/2021 11:04 AM
 */
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class O6_UnitSeed implements ApplicationListener<ApplicationReadyEvent>, Ordered {

    private final UnitRepository unitRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        long count = unitRepository.countByNameInIgnoreCase(List.of("Dus", "Bungkus"));
        if (count == 0) {
            insertData();
            log.info("seed data unit success");
        } else {
            log.info("no need to seed unit data");
        }
    }

    private void insertData() {
        Unit dus = new Unit();
        dus.setName("Dus");

        Unit bungkus = new Unit();
        bungkus.setName("Bungkus");

        List<Unit> units = unitRepository.saveAll(List.of(dus, bungkus));
        log.info(String.valueOf(units));
    }

    @Override
    public int getOrder() {
        return 6;
    }
}
