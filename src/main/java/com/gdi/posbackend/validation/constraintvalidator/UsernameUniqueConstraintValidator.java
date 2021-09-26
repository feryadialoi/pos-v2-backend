package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.UserRepository;
import com.gdi.posbackend.validation.constraint.UsernameUnique;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/14/2021 11:50 AM
 */
public class UsernameUniqueConstraintValidator implements ConstraintValidator<UsernameUnique, String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if (username == null) return true; // skip validation
        return !userRepository.existsByUsername(username);
    }
}
