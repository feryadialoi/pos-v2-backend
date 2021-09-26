package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.SalesmanRepository;
import com.gdi.posbackend.validation.constraint.SalesmanExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/18/2021 5:56 AM
 */
public class SalesmanExistsConstraintValidator implements ConstraintValidator<SalesmanExists, String> {

    @Autowired
    private SalesmanRepository salesmanRepository;

    @Override
    public boolean isValid(String salesmanId, ConstraintValidatorContext constraintValidatorContext) {
        if (salesmanId == null) return true; // skip validation
        return salesmanRepository.existsById(salesmanId);
    }
}
