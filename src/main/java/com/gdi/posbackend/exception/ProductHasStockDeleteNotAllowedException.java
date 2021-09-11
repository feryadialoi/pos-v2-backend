package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/10/2021 12:38 AM
 */
public class ProductHasStockDeleteNotAllowedException extends RuntimeException {
    public ProductHasStockDeleteNotAllowedException() {
    }

    public ProductHasStockDeleteNotAllowedException(String message) {
        super(message);
    }
}
