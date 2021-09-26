package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.SupplierExistsConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/18/2021 5:58 AM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = SupplierExistsConstraintValidator.class)
public @interface SupplierExists {
    String message() default "supplier with id ${validatedValue} not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
