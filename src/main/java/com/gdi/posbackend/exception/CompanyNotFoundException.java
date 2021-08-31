package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/29/2021 4:02 PM
 */
public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException() {
    }

    public CompanyNotFoundException(String message) {
        super(message);
    }
}
