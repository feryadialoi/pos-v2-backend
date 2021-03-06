package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.UnitExistsConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/18/2021 5:49 AM
 */
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UnitExistsConstraintValidator.class)
public @interface UnitExists {
    String message() default "unit not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
