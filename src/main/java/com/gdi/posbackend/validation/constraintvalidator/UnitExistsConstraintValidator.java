package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.UnitRepository;
import com.gdi.posbackend.validation.constraint.UnitExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/18/2021 5:49 AM
 */
public class UnitExistsConstraintValidator implements ConstraintValidator<UnitExists, String> {

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public boolean isValid(String unitId, ConstraintValidatorContext constraintValidatorContext) {
        if (unitId == null) return true; // skip validation
        return unitRepository.existsById(unitId);
    }
}
