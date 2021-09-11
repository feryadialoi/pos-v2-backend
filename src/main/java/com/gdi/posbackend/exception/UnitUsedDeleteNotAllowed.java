package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/10/2021 1:54 PM
 */
public class UnitUsedDeleteNotAllowed extends RuntimeException {
    public UnitUsedDeleteNotAllowed() {
    }

    public UnitUsedDeleteNotAllowed(String message) {
        super(message);
    }
}
