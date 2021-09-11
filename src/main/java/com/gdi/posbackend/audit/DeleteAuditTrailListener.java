package com.gdi.posbackend.audit;

import com.gdi.posbackend.security.ApplicationUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.PreRemove;

/**
 * @author Feryadialoi
 * @date 9/10/2021 10:18 AM
 */
@Slf4j
public class DeleteAuditTrailListener {

    @PreRemove
    void afterAnyRemove(Object object) {
        log.info(SecurityContextHolder.getContext().toString());
        log.info(object.toString());

        ApplicationUserDetails userDetails = (ApplicationUserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        String userId = userDetails.getId();
    }
}
