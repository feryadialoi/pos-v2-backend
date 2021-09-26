package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.ProductRepository;
import com.gdi.posbackend.validation.constraint.ProductCodeUnique;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/18/2021 7:30 PM
 */
public class ProductCodeUniqueConstraintValidator implements ConstraintValidator<ProductCodeUnique, String> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean isValid(String productCode, ConstraintValidatorContext constraintValidatorContext) {
        if (productCode == null) return true; // skip validation
        return !productRepository.existsByCode(productCode);
    }
}
