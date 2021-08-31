package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/25/2021 4:51 PM
 */
public class ChartOfAccountNotFoundException extends RuntimeException {
    public ChartOfAccountNotFoundException() {
    }

    public ChartOfAccountNotFoundException(String message) {
        super(message);
    }
}
