package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.core.BaseControllerAdvice;
import com.gdi.posbackend.exception.PurchaseOrderNotFoundException;
import com.gdi.posbackend.exception.UpdatePurchaseOrderStatusNotAllowedException;
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
        return response("not found", purchaseOrderNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UpdatePurchaseOrderStatusNotAllowedException.class)
    public Object updatePurchaseOrderStatusNotAllowed(UpdatePurchaseOrderStatusNotAllowedException updatePurchaseOrderStatusNotAllowedException) {
        return response("bad request", updatePurchaseOrderStatusNotAllowedException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
