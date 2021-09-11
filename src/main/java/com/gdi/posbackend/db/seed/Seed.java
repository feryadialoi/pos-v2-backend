package com.gdi.posbackend.db.seed;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/25/2021 2:47 PM
 */
@Slf4j
//@Component
@AllArgsConstructor
public class Seed implements ApplicationListener<ApplicationReadyEvent> {

    private final SeedCategoryBrandProduct seedCategoryBrandProduct;
    private final SeedCompanySetting seedCompanySetting;
    private final SeedRunningNumber seedRunningNumber;
    private final SeedUserAndRole seedUserAndRole;
    private final SeedChartOfAccount seedChartOfAccount;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        seedUserAndRole.seed();
        seedChartOfAccount.seed();
        seedCompanySetting.seed();
        seedRunningNumber.seed();
        seedCategoryBrandProduct.seed();

    }
}
