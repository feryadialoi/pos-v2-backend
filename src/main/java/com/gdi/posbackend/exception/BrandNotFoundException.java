package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/13/2021 3:11 PM
 */
public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException() {
    }

    public BrandNotFoundException(String message) {
        super(message);
    }
}
