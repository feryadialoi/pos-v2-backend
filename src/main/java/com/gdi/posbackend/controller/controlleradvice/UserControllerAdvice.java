package com.gdi.posbackend.controller.controlleradvice;

import com.gdi.posbackend.controller.core.BaseControllerAdvice;
import com.gdi.posbackend.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 9/16/2021 11:47 PM
 */
@RestControllerAdvice
public class UserControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public Object userNotFound(UserNotFoundException userNotFoundException) {
        return response("user not found", userNotFoundException.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}
