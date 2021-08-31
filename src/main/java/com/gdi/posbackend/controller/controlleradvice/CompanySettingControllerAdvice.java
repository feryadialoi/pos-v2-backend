package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.exception.CompanySettingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 8/30/2021 11:15 AM
 */
@RestControllerAdvice
public class CompanySettingControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(CompanySettingNotFoundException.class)
    public Object companySettingNotFound(CompanySettingNotFoundException companySettingNotFoundException) {
        return response("not found", companySettingNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
