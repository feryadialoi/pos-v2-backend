package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/16/2021 3:55 PM
 */
public class UpdateSaleOrderStatusNotAllowedException extends RuntimeException {
    public UpdateSaleOrderStatusNotAllowedException() {
    }

    public UpdateSaleOrderStatusNotAllowedException(String message) {
        super(message);
    }
}
