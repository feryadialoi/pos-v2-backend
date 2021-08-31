package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/25/2021 10:37 AM
 */
public class CompanySettingNotFoundException extends RuntimeException {
    public CompanySettingNotFoundException() {
    }

    public CompanySettingNotFoundException(String message) {
        super(message);
    }
}
