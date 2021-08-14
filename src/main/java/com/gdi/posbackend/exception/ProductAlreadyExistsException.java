package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/14/2021 1:39 AM
 */
public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException() {
    }

    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
