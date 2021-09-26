package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.UserExistsConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/18/2021 6:11 AM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UserExistsConstraintValidator.class)
public @interface UserExists {
    String message() default "user with id ${validatedValue} not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
