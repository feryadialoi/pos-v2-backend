package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.WarehouseExistsConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/18/2021 5:51 AM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = WarehouseExistsConstraintValidator.class)
public @interface WarehouseExists {
    String message() default "product not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
