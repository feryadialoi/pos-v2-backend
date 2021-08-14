package com.gdi.posbackend.validation;

import com.gdi.posbackend.repository.CategoryRepository;
import com.gdi.posbackend.validation.constraint.CategoryExistsConstraint;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 8/13/2021 3:45 PM
 */
public class CategoryExistsConstraintValidator implements ConstraintValidator<CategoryExistsConstraint, String> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean isValid(String categoryId, ConstraintValidatorContext constraintValidatorContext) {
        return categoryRepository.existsById(categoryId);
    }
}
