package com.gdi.posbackend.exception;

/**
 * @author Feryadialoi
 * @date 8/31/2021 3:28 PM
 */
public class JournalEntryNotBalanceException extends RuntimeException {

    public JournalEntryNotBalanceException() {

    }

    public JournalEntryNotBalanceException(String message) {
        super(message);
    }
}
