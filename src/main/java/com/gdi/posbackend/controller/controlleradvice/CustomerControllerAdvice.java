package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 9/5/2021 2:05 AM
 */
@RestControllerAdvice
public class CustomerControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(CustomerNotFoundException.class)
    public Object customerNotFound(CustomerNotFoundException customerNotFoundException) {
        return response("not found", customerNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
