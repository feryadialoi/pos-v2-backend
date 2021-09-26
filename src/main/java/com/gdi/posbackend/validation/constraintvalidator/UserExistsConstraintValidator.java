package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.UserRepository;
import com.gdi.posbackend.validation.constraint.UserExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/18/2021 6:12 AM
 */
public class UserExistsConstraintValidator implements ConstraintValidator<UserExists, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String userId, ConstraintValidatorContext constraintValidatorContext) {
        if (userId == null) return true; // skip validation
        return userRepository.existsById(userId);
    }
}
