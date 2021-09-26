package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/17/2021 10:12 AM
 */
public class SaleOrderAlreadyCreateToSaleException extends RuntimeException {
    public SaleOrderAlreadyCreateToSaleException() {
    }

    public SaleOrderAlreadyCreateToSaleException(String message) {
        super(message);
    }
}
