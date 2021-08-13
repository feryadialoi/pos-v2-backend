package com.gdi.posbackend.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Feryadialoi
 * @date 7/17/2021 7:31 AM
 */
public class AuthenticationTokenNotFoundException extends AuthenticationException {
    public AuthenticationTokenNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public AuthenticationTokenNotFoundException(String msg) {
        super(msg);
    }
}

