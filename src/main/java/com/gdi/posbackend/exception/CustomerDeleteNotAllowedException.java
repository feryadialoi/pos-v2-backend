package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/14/2021 2:49 PM
 */
public class CustomerDeleteNotAllowedException extends RuntimeException {
    public CustomerDeleteNotAllowedException() {}

    public CustomerDeleteNotAllowedException(String message) {
        super(message);
    }
}
