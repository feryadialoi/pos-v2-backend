package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/10/2021 2:27 PM
 */
public class WarehouseUsedDeleteNotAllowed extends RuntimeException {

    public WarehouseUsedDeleteNotAllowed() {
    }

    public WarehouseUsedDeleteNotAllowed(String message) {
        super(message);
    }
}
