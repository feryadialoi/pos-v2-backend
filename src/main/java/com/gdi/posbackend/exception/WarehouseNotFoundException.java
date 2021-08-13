package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/5/2021 12:08 AM
 */
public class WarehouseNotFoundException extends RuntimeException {
    public WarehouseNotFoundException() {
    }

    public WarehouseNotFoundException(String message) {
        super(message);
    }
}
