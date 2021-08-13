package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 7/16/2021 11:50 AM
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
