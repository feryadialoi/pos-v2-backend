package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.core.BaseControllerAdvice;
import com.gdi.posbackend.exception.ChartOfAccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 8/30/2021 11:14 AM
 */
@RestControllerAdvice
public class ChartOfAccountControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(ChartOfAccountNotFoundException.class)
    public Object chartOfAccountNotFound(ChartOfAccountNotFoundException chartOfAccountNotFoundException) {
        return response("not found", chartOfAccountNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
