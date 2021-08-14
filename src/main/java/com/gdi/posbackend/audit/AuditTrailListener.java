package com.gdi.posbackend.audit;

import com.gdi.posbackend.entity.auth.User;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 * @author Feryadialoi
 * @date 7/24/2021 10:10 AM
 */
@Slf4j
public class AuditTrailListener {

    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(User user) {
        if (user.getId() == null) {
            log.info("[USER AUDIT] About to add a user");
        } else {
            log.info("[USER AUDIT] About to update/delete user: " + user.getId());
        }
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(User user) {
        log.info("[USER AUDIT] add/update/delete complete for user: " + user.getId());
    }

    @PostLoad
    private void afterLoad(User user) {
        log.info("[USER AUDIT] user loaded from database: " + user.getId());
    }
}
