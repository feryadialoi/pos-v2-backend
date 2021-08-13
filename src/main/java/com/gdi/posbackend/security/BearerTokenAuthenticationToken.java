package com.gdi.posbackend.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author Feryadialoi
 * @date 7/29/2021 10:10 PM
 */
public class BearerTokenAuthenticationToken extends AbstractAuthenticationToken {
    public BearerTokenAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
