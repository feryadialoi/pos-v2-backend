package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.CompanyRepository;
import com.gdi.posbackend.validation.constraint.CompanyExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/14/2021 12:47 PM
 */
public class CompanyExistConstraintValidator implements ConstraintValidator<CompanyExists, String> {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public boolean isValid(String companyId, ConstraintValidatorContext constraintValidatorContext) {
        if (companyId == null) return true; // skip validation
        return companyRepository.existsById(companyId);
    }

}
