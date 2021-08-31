package com.gdi.posbackend.controller;

import com.gdi.posbackend.model.response.ApiResponse;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Feryadialoi
 * @date 7/30/2021 1:40 PM
 */
public abstract class BaseController {

    public <T> ResponseEntity<ApiResponse<T>> response(String message, T data) {
        return response(message, data, HttpStatus.OK);
    }

    public <T> ResponseEntity<ApiResponse<T>> response(String message, T data, HttpStatus httpStatus) {
        return new ResponseEntity<>(
                new ApiResponse<>(message, data, null),
                httpStatus
        );
    }
}
