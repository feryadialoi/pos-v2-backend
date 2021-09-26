package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.model.request.CreateUserRequest;
import com.gdi.posbackend.validation.constraint.ConfirmationPasswordMatchConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/14/2021 10:21 AM
 */
public class ConfirmationPasswordMatchConstraintValidator implements ConstraintValidator<ConfirmationPasswordMatchConstraint, CreateUserRequest> {
    @Override
    public boolean isValid(CreateUserRequest createUserRequest, ConstraintValidatorContext constraintValidatorContext) {
        return createUserRequest
                .getPassword()
                .equals(createUserRequest.getConfirmationPassword());
    }
}
