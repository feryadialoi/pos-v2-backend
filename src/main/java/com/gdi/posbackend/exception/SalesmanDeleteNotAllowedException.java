package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/14/2021 4:34 PM
 */
public class SalesmanDeleteNotAllowedException extends RuntimeException {
    public SalesmanDeleteNotAllowedException() {
    }

    public SalesmanDeleteNotAllowedException(String message) {
        super(message);
    }
}
