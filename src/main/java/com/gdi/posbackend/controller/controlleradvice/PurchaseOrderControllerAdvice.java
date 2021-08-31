package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.exception.PurchaseOrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 8/23/2021 4:28 PM
 */
@RestControllerAdvice
public class PurchaseOrderControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(PurchaseOrderNotFoundException.class)
    public Object purchaseOrderNotFound(PurchaseOrderNotFoundException purchaseOrderNotFoundException) {
        return response("not found",
                purchaseOrderNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }
}
