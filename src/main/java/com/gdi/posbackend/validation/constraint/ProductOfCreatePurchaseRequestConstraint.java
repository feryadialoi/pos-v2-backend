package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.ProductOfCreatePurchaseOrderRequestConstraintValidator;
import com.gdi.posbackend.validation.ProductOfCreatePurchaseRequestConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/6/2021 1:36 PM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ProductOfCreatePurchaseRequestConstraintValidator.class)
public @interface ProductOfCreatePurchaseRequestConstraint {
    String message() default "Product not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
