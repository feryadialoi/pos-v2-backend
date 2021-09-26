package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.core.BaseControllerAdvice;
import com.gdi.posbackend.exception.PurchaseReturnNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 8/30/2021 11:18 AM
 */
@RestControllerAdvice
public class PurchaseReturnControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(PurchaseReturnNotFoundException.class)
    public Object purchaseReturnNotFound(PurchaseReturnNotFoundException purchaseReturnNotFoundException) {
        return response("not found", purchaseReturnNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
