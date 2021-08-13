package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 7/16/2021 11:10 AM
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
