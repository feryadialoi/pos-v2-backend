package com.gdi.posbackend.validation.constraint;

import com.gdi.posbackend.validation.CategoryExistsConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feryadialoi
 * @date 8/13/2021 3:42 PM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CategoryExistsConstraintValidator.class)
public @interface CategoryExistsConstraint {
    String message() default "Category not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
