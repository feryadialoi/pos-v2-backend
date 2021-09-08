package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 9/7/2021 4:19 PM
 */
public class AdjustmentJournalNotFoundException extends RuntimeException {
    public AdjustmentJournalNotFoundException(String message) {
        super(message);
    }
}
