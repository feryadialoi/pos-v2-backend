package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.UsernameUniqueConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/14/2021 11:49 AM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UsernameUniqueConstraintValidator.class)
public @interface UsernameUnique {
    String message() default "username of ${validatedValue} already taken";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
