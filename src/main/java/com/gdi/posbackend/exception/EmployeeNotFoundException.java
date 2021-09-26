package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/13/2021 4:03 PM
 */
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {

    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
