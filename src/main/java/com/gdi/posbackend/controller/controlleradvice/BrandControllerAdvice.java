package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.exception.BrandNotFoundException;
import com.gdi.posbackend.exception.BrandUsedDeleteNotAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 9/10/2021 1:26 PM
 */
@RestControllerAdvice
public class BrandControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(BrandNotFoundException.class)
    public Object brandNotFound(BrandNotFoundException brandNotFoundException) {
        return response("not found", brandNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BrandUsedDeleteNotAllowed.class)
    public Object brandUsedDeleteNotAllowed(BrandUsedDeleteNotAllowed brandUsedDeleteNotAllowed) {
        return response("bad request", brandUsedDeleteNotAllowed.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
