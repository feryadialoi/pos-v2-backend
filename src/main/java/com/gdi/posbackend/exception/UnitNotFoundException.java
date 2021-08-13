package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:21 AM
 */
public class UnitNotFoundException extends RuntimeException {
    public UnitNotFoundException() {
    }

    public UnitNotFoundException(String message) {
        super(message);
    }
}
