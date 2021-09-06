package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.exception.SaleOrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 9/5/2021 2:06 AM
 */
@RestControllerAdvice
public class SaleOrderControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(SaleOrderNotFoundException.class)
    public Object saleOrderNotFound(SaleOrderNotFoundException saleOrderNotFoundException) {
        return response("not found", saleOrderNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
