package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.PurchaseOrderExistsIfPresentConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/18/2021 4:56 AM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PurchaseOrderExistsIfPresentConstraintValidator.class)
public @interface PurchaseOrderExistsIfPresent {
    String message() default "purchase order not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
