package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.PurchaseOrderPresentUnusedConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/18/2021 4:44 AM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PurchaseOrderPresentUnusedConstraintValidator.class)
public @interface PurchaseOrderPresentUnused {
    String message() default "purchase order already create to purchase";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
