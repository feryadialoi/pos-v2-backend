package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.constraintvalidator.ProductCodeUniqueConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 9/18/2021 7:29 PM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ProductCodeUniqueConstraintValidator.class)
public @interface ProductCodeUnique {

    String message() default "product code of ${validatedValue} already taken";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
