package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/5/2021 9:50 AM
 */
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException() {
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
