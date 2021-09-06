package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:24 AM
 */
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
