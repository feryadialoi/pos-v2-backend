package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/6/2021 11:17 AM
 */
public class CompletePurchaseOrderNotAllowedException extends RuntimeException {
    public CompletePurchaseOrderNotAllowedException() {}

    public CompletePurchaseOrderNotAllowedException(String message) {
        super(message);
    }
}
