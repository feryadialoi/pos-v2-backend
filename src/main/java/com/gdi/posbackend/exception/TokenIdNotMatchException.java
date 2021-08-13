package com.gdi.posbackend.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Feryadialoi
 * @date 7/17/2021 7:28 AM
 */
public class TokenIdNotMatchException extends AuthenticationException {
    public TokenIdNotMatchException(String message) {
        super(message);
    }
}

