package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.ProductRepository;
import com.gdi.posbackend.validation.constraint.ProductExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/18/2021 5:48 AM
 */
public class ProductExistsConstraintValidator implements ConstraintValidator<ProductExists, String> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean isValid(String productId, ConstraintValidatorContext constraintValidatorContext) {
        if (productId == null) return true; // skip validation
        return productRepository.existsById(productId);
    }
}
