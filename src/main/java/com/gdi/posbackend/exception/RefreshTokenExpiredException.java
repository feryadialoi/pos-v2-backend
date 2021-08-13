package com.gdi.posbackend.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Feryadialoi
 * @date 7/17/2021 7:24 AM
 */
public class RefreshTokenExpiredException extends AuthenticationException {
    public RefreshTokenExpiredException(String message) {
        super(message);
    }
}
