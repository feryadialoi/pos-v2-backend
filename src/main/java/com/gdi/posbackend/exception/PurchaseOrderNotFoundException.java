package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/23/2021 4:27 PM
 */
public class PurchaseOrderNotFoundException extends RuntimeException {
    public PurchaseOrderNotFoundException() {

    }

    public PurchaseOrderNotFoundException(String message) {
        super(message);
    }
}
