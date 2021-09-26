package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.CustomerRepository;
import com.gdi.posbackend.validation.constraint.CustomerExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/18/2021 5:55 AM
 */
public class CustomerExistsConstraintValidator implements ConstraintValidator<CustomerExists, String> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean isValid(String customerId, ConstraintValidatorContext constraintValidatorContext) {
        if (customerId == null) return true; // skip validation
        return customerRepository.existsById(customerId);
    }
}
