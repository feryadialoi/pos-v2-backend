package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/10/2021 11:00 AM
 */
public class CategoryUsedDeleteNotAllowedException extends RuntimeException {

    public CategoryUsedDeleteNotAllowedException() {
    }

    public CategoryUsedDeleteNotAllowedException(String message) {
        super(message);
    }
}
