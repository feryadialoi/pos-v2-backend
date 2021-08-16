package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/16/2021 1:40 PM
 */
public class SupplierNotFoundException extends RuntimeException {

    public SupplierNotFoundException() {
    }

    public SupplierNotFoundException(String message) {
        super(message);
    }
}
