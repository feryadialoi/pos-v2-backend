package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/3/2021 4:26 PM
 */
public class ProductStockInsufficientException extends RuntimeException {
    public ProductStockInsufficientException() {
    }

    public ProductStockInsufficientException(String message) {
        super(message);
    }
}
