package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.exception.ProductAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Feryadialoi
 * @date 8/14/2021 4:56 PM
 */
@ControllerAdvice
public class ProductErrorController extends BaseControllerAdvice {

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public Object productAlreadyExists(ProductAlreadyExistsException productAlreadyExistsException) {
        return response(
                "conflict",
                productAlreadyExistsException.getMessage(),
                HttpStatus.CONFLICT
        );
    }

}
