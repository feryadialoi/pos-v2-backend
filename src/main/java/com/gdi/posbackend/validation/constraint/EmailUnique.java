package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.EmailUniqueConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/14/2021 11:45 AM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailUniqueConstraintValidator.class)
public @interface EmailUnique {
    String message() default "email of ${validatedValue} already taken";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
