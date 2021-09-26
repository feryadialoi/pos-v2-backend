package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.BrandExistsConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 8/13/2021 3:44 PM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = BrandExistsConstraintValidator.class)
public @interface BrandExists {
    String message() default "brand with id ${validatedValue} not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
