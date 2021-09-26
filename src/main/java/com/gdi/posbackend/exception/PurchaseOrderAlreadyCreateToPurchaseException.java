package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/17/2021 10:41 AM
 */
public class PurchaseOrderAlreadyCreateToPurchaseException extends RuntimeException {
    public PurchaseOrderAlreadyCreateToPurchaseException() {
    }

    public PurchaseOrderAlreadyCreateToPurchaseException(String message) {
        super(message);
    }
}
