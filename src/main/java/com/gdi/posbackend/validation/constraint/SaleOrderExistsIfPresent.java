package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.SaleOrderExistsIfPresentConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/18/2021 4:48 AM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = SaleOrderExistsIfPresentConstraintValidator.class)
public @interface SaleOrderExistsIfPresent {
    String message() default "sale order not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
