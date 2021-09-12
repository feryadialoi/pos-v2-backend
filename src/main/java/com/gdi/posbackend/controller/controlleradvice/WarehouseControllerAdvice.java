package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.exception.WarehouseNotFoundException;
import com.gdi.posbackend.exception.WarehouseDeleteNotAllowedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 9/11/2021 10:54 AM
 */
@RestControllerAdvice
public class WarehouseControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(WarehouseNotFoundException.class)
    public Object warehouseNotFound(WarehouseNotFoundException warehouseNotFoundException) {
        return response("not found", warehouseNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WarehouseDeleteNotAllowedException.class)
    public Object warehouseUsedDeleteNotAllowed(WarehouseDeleteNotAllowedException warehouseDeleteNotAllowedException) {
        return response("bad request", warehouseDeleteNotAllowedException.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
