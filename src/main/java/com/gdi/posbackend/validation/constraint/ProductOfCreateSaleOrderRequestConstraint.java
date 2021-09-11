package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.ProductOfCreatePurchaseRequestConstraintValidator;
import com.gdi.posbackend.validation.ProductOfCreateSaleOrderRequestConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/9/2021 1:01 PM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ProductOfCreateSaleOrderRequestConstraintValidator.class)
public @interface ProductOfCreateSaleOrderRequestConstraint {
    String message() default "Product not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
