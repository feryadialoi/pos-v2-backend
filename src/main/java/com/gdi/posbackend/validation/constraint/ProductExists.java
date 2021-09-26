package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.ProductExistsConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/18/2021 5:47 AM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ProductExistsConstraintValidator.class)
public @interface ProductExists {
    String message() default "product with id ${validatedValue} not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
