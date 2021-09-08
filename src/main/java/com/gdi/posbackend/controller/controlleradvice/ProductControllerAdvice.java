package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.exception.ProductAlreadyExistsException;
import com.gdi.posbackend.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Feryadialoi
 * @date 8/14/2021 4:56 PM
 */
@ControllerAdvice
public class ProductControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public Object productAlreadyExists(ProductAlreadyExistsException productAlreadyExistsException) {
        return response(
                "conflict",
                productAlreadyExistsException.getMessage(),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public Object productNotFound(ProductNotFoundException productNotFoundException) {
        return response("not found", productNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
