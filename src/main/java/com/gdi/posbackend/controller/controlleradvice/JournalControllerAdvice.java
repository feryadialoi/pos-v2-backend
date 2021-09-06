package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.exception.JournalEntryNotBalanceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 8/31/2021 3:30 PM
 */
@RestControllerAdvice
public class JournalControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(JournalEntryNotBalanceException.class)
    public Object journalEntryNotBalance(JournalEntryNotBalanceException journalEntryNotBalanceException) {
        return response("internal error", journalEntryNotBalanceException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
