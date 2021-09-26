package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.ProductStockSufficientForSaleConstraintValidator;
import com.gdi.posbackend.validation.constraintvalidator.ProductStockSufficientForSaleOrderConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/18/2021 5:31 AM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ProductStockSufficientForSaleConstraintValidator.class)
public @interface ProductStockSufficientForSale {
    String message() default "product stock insufficient";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
