package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/15/2021 11:44 PM
 */
public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException() {
    }

    public RoleNotFoundException(String message) {
        super(message);
    }
}
