package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.exception.CategoryNotFoundException;
import com.gdi.posbackend.exception.UnitNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:00 AM
 */
@RestControllerAdvice
public class UnitErrorControllerAdvice extends BaseControllerAdvice {
    @ExceptionHandler(UnitNotFoundException.class)
    public Object unitNotFound(UnitNotFoundException unitNotFoundException) {
        return response("not found",
                unitNotFoundException.getMessage(), HttpStatus.NOT_FOUND
        );
    }
}
