package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:26 AM
 */
public class SalesmanNotFoundException extends RuntimeException {
    public SalesmanNotFoundException() {
    }

    public SalesmanNotFoundException(String message) {
        super(message);
    }
}
