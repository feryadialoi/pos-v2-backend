package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/10/2021 2:27 PM
 */
public class WarehouseDeleteNotAllowedException extends RuntimeException {

    public WarehouseDeleteNotAllowedException() {
    }

    public WarehouseDeleteNotAllowedException(String message) {
        super(message);
    }
}
