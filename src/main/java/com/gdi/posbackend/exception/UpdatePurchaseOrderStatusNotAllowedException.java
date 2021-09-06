package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/7/2021 1:34 AM
 */
public class UpdatePurchaseOrderStatusNotAllowedException extends RuntimeException {
    public UpdatePurchaseOrderStatusNotAllowedException() {}

    public UpdatePurchaseOrderStatusNotAllowedException(String message) {
        super(message);
    }
}
