package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.CategoryRepository;
import com.gdi.posbackend.validation.constraint.CategoryExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 8/13/2021 3:45 PM
 */
public class CategoryExistsConstraintValidator implements ConstraintValidator<CategoryExists, String> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean isValid(String categoryId, ConstraintValidatorContext constraintValidatorContext) {
        if (categoryId == null) return true; // skip validation
        return categoryRepository.existsById(categoryId);
    }
}
