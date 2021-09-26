package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.core.BaseControllerAdvice;
import com.gdi.posbackend.exception.CompanyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 8/30/2021 11:12 AM
 */
@RestControllerAdvice
public class CompanyControllerAdvice extends BaseControllerAdvice {
    @ExceptionHandler(CompanyNotFoundException.class)
    public Object companyNotFound(CompanyNotFoundException companyNotFoundException) {
        return response("not found", companyNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
