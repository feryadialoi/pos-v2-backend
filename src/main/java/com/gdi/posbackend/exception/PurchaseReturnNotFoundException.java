package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/29/2021 4:14 AM
 */
public class PurchaseReturnNotFoundException extends RuntimeException {
    public PurchaseReturnNotFoundException(){}

    public PurchaseReturnNotFoundException(String message) {
        super(message);
    }
}
