package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.BrandRepository;
import com.gdi.posbackend.validation.constraint.BrandExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 8/13/2021 3:48 PM
 */
public class BrandExistsConstraintValidator implements ConstraintValidator<BrandExists, String> {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public boolean isValid(String brandId, ConstraintValidatorContext constraintValidatorContext) {
        if (brandId == null) return true; // skip validation
        return brandRepository.existsById(brandId);
    }
}
