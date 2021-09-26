package com.gdi.posbackend.controller.controlleradvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.gdi.posbackend.controller.core.BaseControllerAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

/**
 * @author Feryadialoi
 * @date 8/4/2021 11:53 PM
 */
@Slf4j
@RestControllerAdvice
public class ErrorControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object methodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException) {
        return response("Unprocessable entity",
                        getNotValidDetails(methodArgumentNotValidException.getBindingResult().getAllErrors()),
                        HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    @ExceptionHandler(BindException.class)
    public Object bind(BindException bindException) {
        return response("Unprocessable entity",
                        getNotValidDetails(bindException.getBindingResult().getAllErrors()),
                        HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object httpMessageNotReadable(HttpMessageNotReadableException httpMessageNotReadableException) {
        return response("Bad request",
                        getHttpMessageNotReadable(httpMessageNotReadableException),
                        HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Object sqlIntegrityConstraintViolation(SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException) {
        return response("bad request",
                        sqlIntegrityConstraintViolationException.getMessage(),
                        HttpStatus.BAD_REQUEST
        );
    }


    private String getHttpMessageNotReadable(HttpMessageNotReadableException httpMessageNotReadableException) {
        Throwable cause = httpMessageNotReadableException.getRootCause();
        String message = cause != null ? cause.getMessage() : "Required request body is missing";

        if (cause instanceof InvalidFormatException) message = invalidFormat((InvalidFormatException) cause);
        else if (cause instanceof MismatchedInputException) message = mismatchedInput((MismatchedInputException) cause);
        return message;
    }

    private Map<String, String> getNotValidDetails(List<ObjectError> objectErrors) {
        Map<String, String> errors = new HashMap<>();
        for (ObjectError objectError : objectErrors) {
            String propertyName = objectError instanceof FieldError ? ((FieldError) objectError).getField() : objectError.getObjectName();
            String errorMessage = objectError.getDefaultMessage();
            errors.merge(propertyName, errorMessage, (a, b) -> a + ", " + b);
        }
        return errors;
    }

    private String mismatchedInput(MismatchedInputException mismatchedInputException) {
        int index = mismatchedInputException.getPath().size() - 1;
        String fieldName = mismatchedInputException.getPath().get(index).getFieldName();
        return "invalid value for " + fieldName;
    }

    private String invalidFormat(InvalidFormatException invalidFormatException) {
        int index = invalidFormatException.getPath().size() - 1;
        String targetType = invalidFormatException.getTargetType().getName();
        String fieldName = invalidFormatException.getPath().get(index).getFieldName();
        Object value = invalidFormatException.getValue();

        String message = String.format("value %s for %s is not valid %s", value, fieldName, targetType);

        if (invalidFormatException.getTargetType().isEnum()) {
            Object[] enumConstants = invalidFormatException.getTargetType().getEnumConstants();
            message = String.format("value %s for %s not one of the values %s", value, fieldName, Arrays.toString(enumConstants));
        }

        return message;
    }

}

