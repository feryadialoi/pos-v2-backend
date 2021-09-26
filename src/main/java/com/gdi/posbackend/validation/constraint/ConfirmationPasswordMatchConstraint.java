package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.ConfirmationPasswordMatchConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/14/2021 10:20 AM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ConfirmationPasswordMatchConstraintValidator.class)
public @interface ConfirmationPasswordMatchConstraint {
    String message() default "confirmation password not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
