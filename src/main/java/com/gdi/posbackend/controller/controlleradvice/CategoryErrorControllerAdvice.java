package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.exception.CategoryNotFoundException;
import com.gdi.posbackend.exception.CategoryUsedDeleteNotAllowedException;
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

    @ExceptionHandler(CategoryUsedDeleteNotAllowedException.class)
    public Object categoryUsedDeletdNotAllowed(CategoryUsedDeleteNotAllowedException categoryUsedDeleteNotAllowedException) {
        return response("bad request", categoryUsedDeleteNotAllowedException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
