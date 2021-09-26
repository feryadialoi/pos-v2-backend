package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.core.BaseControllerAdvice;
import com.gdi.posbackend.exception.ProductStockDetailNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 8/30/2021 11:17 AM
 */
@RestControllerAdvice
public class ProductStockDetailControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(ProductStockDetailNotFoundException.class)
    public Object productStockDetailNotFound(ProductStockDetailNotFoundException productStockDetailNotFoundException) {
        return response("not found", productStockDetailNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
