package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.CompanyExistConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/14/2021 12:46 PM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CompanyExistConstraintValidator.class)
public @interface CompanyExists {
    String message() default "company with id ${validatedValue} not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
