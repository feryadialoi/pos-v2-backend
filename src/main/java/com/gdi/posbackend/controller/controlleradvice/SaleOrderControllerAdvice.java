package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.core.BaseControllerAdvice;
import com.gdi.posbackend.exception.SaleOrderNotFoundException;
import com.gdi.posbackend.exception.UpdateSaleOrderStatusNotAllowedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 9/5/2021 2:06 AM
 */
@RestControllerAdvice
public class SaleOrderControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(SaleOrderNotFoundException.class)
    public Object saleOrderNotFound(SaleOrderNotFoundException saleOrderNotFoundException) {
        return response("not found", saleOrderNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UpdateSaleOrderStatusNotAllowedException.class)
    public Object updateSaleOrderStatusNotAllowed(UpdateSaleOrderStatusNotAllowedException updateSaleOrderStatusNotAllowedException) {
        return response("bad request", updateSaleOrderStatusNotAllowedException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
