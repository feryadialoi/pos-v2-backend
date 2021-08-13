package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/4/2021 11:52 PM
 */
public class WarehouseDeleteNotAllowedException extends RuntimeException {
    public WarehouseDeleteNotAllowedException() {
    }

    public WarehouseDeleteNotAllowedException(String message) {
        super(message);
    }
}
