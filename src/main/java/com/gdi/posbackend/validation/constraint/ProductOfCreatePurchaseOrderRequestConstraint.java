package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.BrandExistsConstraintValidator;
import com.gdi.posbackend.validation.ProductOfCreatePurchaseOrderRequestConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 8/20/2021 2:51 PM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ProductOfCreatePurchaseOrderRequestConstraintValidator.class)
public @interface ProductOfCreatePurchaseOrderRequestConstraint {
    String message() default "Product not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
