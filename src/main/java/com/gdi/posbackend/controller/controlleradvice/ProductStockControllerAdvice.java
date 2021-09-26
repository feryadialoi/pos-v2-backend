package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.core.BaseControllerAdvice;
import com.gdi.posbackend.exception.ProductStockInsufficientException;
import com.gdi.posbackend.exception.ProductStockNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 8/30/2021 11:16 AM
 */
@RestControllerAdvice
public class ProductStockControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(ProductStockNotFoundException.class)
    public Object productStockNotFound(ProductStockNotFoundException productStockNotFoundException) {
        return response("not found", productStockNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductStockInsufficientException.class)
    public Object productStockInsufficient(ProductStockInsufficientException productStockInsufficientException) {
        return response("bad request", productStockInsufficientException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
