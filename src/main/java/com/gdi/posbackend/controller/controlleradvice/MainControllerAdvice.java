package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.BaseControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 9/7/2021 4:24 PM
 */
@RestControllerAdvice
public class MainControllerAdvice extends BaseControllerAdvice {

//    @ExceptionHandler(RuntimeException.class)
//    public Object runtime(RuntimeException runtimeException) {
//        return response("internal error", runtimeException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }


}
