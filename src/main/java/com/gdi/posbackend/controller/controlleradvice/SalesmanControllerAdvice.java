package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.exception.SaleOrderNotFoundException;
import com.gdi.posbackend.exception.SalesmanNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 9/5/2021 2:06 AM
 */
@RestControllerAdvice
public class SalesmanControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(SaleOrderNotFoundException.class)
    public Object salesmanNotFound(SalesmanNotFoundException salesmanNotFoundException) {
        return response("not found", salesmanNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
