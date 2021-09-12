package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/10/2021 11:00 AM
 */
public class CategoryDeleteNotAllowedException extends RuntimeException {

    public CategoryDeleteNotAllowedException() {
    }

    public CategoryDeleteNotAllowedException(String message) {
        super(message);
    }
}
