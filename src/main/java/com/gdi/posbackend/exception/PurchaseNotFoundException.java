package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/29/2021 4:14 AM
 */
public class PurchaseNotFoundException extends RuntimeException {
    public PurchaseNotFoundException(){}

    public PurchaseNotFoundException(String message) {
        super(message);
    }
}
