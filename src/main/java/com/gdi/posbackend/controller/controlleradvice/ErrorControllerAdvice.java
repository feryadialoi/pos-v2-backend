package com.gdi.posbackend.controller.controlleradvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.gdi.posbackend.controller.BaseControllerAdvice;
import com.gdi.posbackend.controller.controlleradvice.model.NotValidDetail;
import com.gdi.posbackend.exception.WarehouseDeleteNotAllowedException;
import com.gdi.posbackend.exception.WarehouseNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/4/2021 11:53 PM
 */
@Slf4j
@RestControllerAdvice
public class ErrorControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(WarehouseNotFoundException.class)
    public Object warehouseNotFound(WarehouseNotFoundException warehouseNotFoundException) {
        return response("warehouse delete not allowed",
                warehouseNotFoundException.getMessage(), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(WarehouseDeleteNotAllowedException.class)
    public Object warehouseDeleteNotAllowed(WarehouseDeleteNotAllowedException warehouseDeleteNotAllowedException) {
        return response("warehouse delete not allowed",
                warehouseDeleteNotAllowedException.getMessage(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object methodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<NotValidDetail> notValidDetails = methodArgumentNotValidException
                .getBindingResult().getAllErrors().stream()
                .map(this::mapObjectErrorToNotValidDetail)
                .collect(Collectors.toList());

        return response("Unprocessable entity",
                notValidDetails, HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    @ExceptionHandler(BindException.class)
    public Object bind(BindException bindException) {
        List<NotValidDetail> notValidDetails = bindException
                .getBindingResult().getAllErrors().stream()
                .map(this::mapObjectErrorToNotValidDetail)
                .collect(Collectors.toList());

        return response("Unprocessable entity",
                notValidDetails, HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object httpMessageNotReadable(HttpMessageNotReadableException httpMessageNotReadableException) {
        Throwable cause = httpMessageNotReadableException.getRootCause();
        String message = cause != null ? cause.getMessage() : "Required request body is missing";

        if (cause instanceof InvalidFormatException) message = invalidFormat((InvalidFormatException) cause);
        else if (cause instanceof MismatchedInputException) message = mismatchedInput((MismatchedInputException) cause);

        return response("Bad request",
                message, HttpStatus.BAD_REQUEST
        );
    }

    private NotValidDetail mapObjectErrorToNotValidDetail(ObjectError objectError) {
        NotValidDetail notValidDetail = new NotValidDetail();
        notValidDetail.setProperty(objectError.getObjectName());
        if (objectError instanceof FieldError)
            notValidDetail.setProperty(((FieldError) objectError).getField());
        notValidDetail.setErrorMessage(objectError.getDefaultMessage());
        return notValidDetail;
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

