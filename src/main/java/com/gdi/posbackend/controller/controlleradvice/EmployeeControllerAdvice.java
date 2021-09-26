package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.core.BaseControllerAdvice;
import com.gdi.posbackend.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 9/14/2021 12:08 PM
 */
@RestControllerAdvice
public class EmployeeControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public Object employeeNotFound(EmployeeNotFoundException employeeNotFoundException) {
        return response("not found", employeeNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
