package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.exception.PurchaseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 8/30/2021 11:18 AM
 */
@RestControllerAdvice
public class PurchaseControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(PurchaseNotFoundException.class)
    public Object purchaseNotFound(PurchaseNotFoundException purchaseNotFoundException) {
        return response("not found", purchaseNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
