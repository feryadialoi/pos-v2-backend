package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.core.BaseControllerAdvice;
import com.gdi.posbackend.exception.CategoryNotFoundException;
import com.gdi.posbackend.exception.CategoryDeleteNotAllowedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:00 AM
 */
@RestControllerAdvice
public class CategoryErrorControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(CategoryNotFoundException.class)
    public Object categoryNotFound(CategoryNotFoundException categoryNotFoundException) {
        return response("not found", categoryNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryDeleteNotAllowedException.class)
    public Object categoryUsedDeletdNotAllowed(CategoryDeleteNotAllowedException categoryDeleteNotAllowedException) {
        return response("bad request", categoryDeleteNotAllowedException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
