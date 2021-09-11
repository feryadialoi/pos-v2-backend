package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/10/2021 12:04 PM
 */
public class BrandUsedDeleteNotAllowed extends RuntimeException {
    public BrandUsedDeleteNotAllowed() {
    }

    public BrandUsedDeleteNotAllowed(String message) {
        super(message);
    }
}
