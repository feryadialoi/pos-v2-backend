package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/10/2021 12:04 PM
 */
public class BrandDeleteNotAllowedException extends RuntimeException {
    public BrandDeleteNotAllowedException() {
    }

    public BrandDeleteNotAllowedException(String message) {
        super(message);
    }
}
