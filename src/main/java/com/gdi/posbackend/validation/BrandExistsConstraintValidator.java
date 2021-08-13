package com.gdi.posbackend.validation;

import com.gdi.posbackend.repository.BrandRepository;
import com.gdi.posbackend.validation.constraint.BrandExistsConstraint;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 8/13/2021 3:48 PM
 */
public class BrandExistsConstraintValidator implements ConstraintValidator<BrandExistsConstraint, Long> {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public boolean isValid(Long brandId, ConstraintValidatorContext constraintValidatorContext) {
        return brandRepository.existsById(brandId);
    }
}
