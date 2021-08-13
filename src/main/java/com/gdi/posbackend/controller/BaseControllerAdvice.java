package com.gdi.posbackend.controller;

import com.gdi.posbackend.model.response.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Feryadialoi
 * @date 8/4/2021 11:00 PM
 */
public abstract class BaseControllerAdvice {

    protected final String X_ERROR_TYPE = "X-Error-Type";

    protected MultiValueMap<String, String> getXErrorTypeHeader(Exception exception) {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add(X_ERROR_TYPE, exception.getClass().getSimpleName());
        headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, X_ERROR_TYPE);
        return headers;
    }

    public <E> ResponseEntity<ApiResponse<Object, E>> response(String message, E error, HttpStatus httpStatus) {

        return response(message, error, null, httpStatus);
    }

    public <E> ResponseEntity<ApiResponse<Object, E>> response(String message, E error, MultiValueMap<String, String> headers, HttpStatus httpStatus) {

        return new ResponseEntity<>(
                new ApiResponse<>(message, null, error),
                headers,
                httpStatus
        );

    }

}
