package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/30/2021 12:39 AM
 */
public class ProductStockNotFoundException extends RuntimeException {
    public ProductStockNotFoundException() {
    }

    public ProductStockNotFoundException(String message) {
        super(message);
    }
}
