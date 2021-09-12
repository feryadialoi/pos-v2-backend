package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/10/2021 1:54 PM
 */
public class UnitDeleteNotAllowedException extends RuntimeException {
    public UnitDeleteNotAllowedException() {
    }

    public UnitDeleteNotAllowedException(String message) {
        super(message);
    }
}
