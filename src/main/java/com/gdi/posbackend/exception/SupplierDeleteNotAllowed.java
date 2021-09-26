package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/14/2021 3:49 PM
 */
public class SupplierDeleteNotAllowed extends RuntimeException {
    public SupplierDeleteNotAllowed() {
    }

    public SupplierDeleteNotAllowed(String message) {
        super(message);
    }
}
