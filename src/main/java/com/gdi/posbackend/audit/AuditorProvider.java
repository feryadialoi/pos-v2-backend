package com.gdi.posbackend.audit;

import com.gdi.posbackend.security.ApplicationUserDetails;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 8/5/2021 4:14 AM
 */
@Component("auditorProvider")
public class AuditorProvider implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null) {
            if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
                return Optional.ofNullable(SecurityContextHolder.getContext())
                        .map(SecurityContext::getAuthentication)
                        .filter(Authentication::isAuthenticated)
                        .map(Authentication::getPrincipal)
                        .map(ApplicationUserDetails.class::cast)
                        .map(ApplicationUserDetails::getId);
            }

            return Optional.empty();
        }
        return Optional.empty();
    }
}