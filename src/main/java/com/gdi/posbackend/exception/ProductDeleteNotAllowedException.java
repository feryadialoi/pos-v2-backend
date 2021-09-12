package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/10/2021 12:38 AM
 */
public class ProductDeleteNotAllowedException extends RuntimeException {
    public ProductDeleteNotAllowedException() {
    }

    public ProductDeleteNotAllowedException(String message) {
        super(message);
    }
}
