package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/6/2021 11:05 AM
 */
public class CreatePurchaseNotAllowedException extends RuntimeException {
    public CreatePurchaseNotAllowedException() {
    }

    public CreatePurchaseNotAllowedException(String message) {
        super(message);
    }
}
