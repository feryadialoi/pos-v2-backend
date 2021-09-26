package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.CustomerExistsConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/18/2021 5:53 AM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CustomerExistsConstraintValidator.class)
public @interface CustomerExists {
    String message() default "customer with id ${validatedValue} not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
