package com.gdi.posbackend.db.seed.ordered;

import com.gdi.posbackend.entity.auth.Permission;
import com.gdi.posbackend.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 7/30/2021 9:43 AM
 */
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class O2_PermissionSeed implements ApplicationListener<ApplicationReadyEvent>, Ordered {

    private final PermissionRepository permissionRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        long count = permissionRepository.count();
        if (count == 0) {
            List<Permission> permissions = getPermissions();
            List<Permission> permissions1 = permissionRepository.saveAll(permissions);
            log.info("seed permissions success, {} roles seeded", permissions1.size());
        } else {
            log.info("no need to seed permissions");
        }
    }

    private List<Permission> getPermissions() {
        return Arrays.asList(
                new Permission("CREATE_COMPANY", "", ""),
                new Permission("GET_COMPANY", "", ""),
                new Permission("GET_COMPANIES", "", ""),
                new Permission("UPDATE_COMPANY", "", ""),
                new Permission("DELETE_COMPANY", "", ""),

                new Permission("CREATE_COMPANY_SETTING", "", ""),
                new Permission("GET_COMPANY_SETTING", "", ""),
                new Permission("GET_COMPANY_SETTINGS", "", ""),
                new Permission("UPDATE_COMPANY_SETTING", "", ""),
                new Permission("DELETE_COMPANY_SETTING", "", "")
        );
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
