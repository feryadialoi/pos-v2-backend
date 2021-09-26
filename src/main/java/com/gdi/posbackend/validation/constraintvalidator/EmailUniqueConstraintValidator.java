package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.UserRepository;
import com.gdi.posbackend.validation.constraint.EmailUnique;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/14/2021 11:45 AM
 */
public class EmailUniqueConstraintValidator implements ConstraintValidator<EmailUnique, String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsByEmail(email);
    }
}
