package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/17/2021 12:07 PM
 */
public class NoCogsMethodProvidedException extends RuntimeException {
    public NoCogsMethodProvidedException() {
    }

    public NoCogsMethodProvidedException(String message) {
        super(message);
    }
}
