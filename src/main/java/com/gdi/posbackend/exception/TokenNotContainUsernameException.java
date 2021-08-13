package com.gdi.posbackend.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Feryadialoi
 * @date 7/16/2021 12:24 PM
 */
public class TokenNotContainUsernameException extends AuthenticationException {
    public TokenNotContainUsernameException(String message) {
        super(message);
    }
}
