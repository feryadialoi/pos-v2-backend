package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 7/16/2021 12:34 PM
 */
public class LoginFailedException extends RuntimeException {
    public LoginFailedException(String message) {
        super(message);
    }
}
