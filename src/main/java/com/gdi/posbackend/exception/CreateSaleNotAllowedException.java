package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/16/2021 10:16 AM
 */
public class CreateSaleNotAllowedException extends RuntimeException {
    public CreateSaleNotAllowedException() {
    }

    public CreateSaleNotAllowedException(String message) {
        super(message);
    }
}
