package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.SaleOrderPresentUnusedConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/18/2021 4:37 AM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = SaleOrderPresentUnusedConstraintValidator.class)
public @interface SaleOrderPresentUnused {
    String message() default "sale order already create to sale";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
