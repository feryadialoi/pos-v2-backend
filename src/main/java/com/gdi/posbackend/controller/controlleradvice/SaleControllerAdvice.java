package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.exception.SaleNotFoundException;
import com.gdi.posbackend.exception.SaleOrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 9/5/2021 2:06 AM
 */
@RestControllerAdvice
public class SaleControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(SaleNotFoundException.class)
    public Object saleNotFound(SaleNotFoundException saleNotFoundException) {
        return response("not found", saleNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
