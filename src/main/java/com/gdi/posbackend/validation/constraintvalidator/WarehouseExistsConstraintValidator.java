package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.WarehouseRepository;
import com.gdi.posbackend.validation.constraint.WarehouseExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/18/2021 5:51 AM
 */
public class WarehouseExistsConstraintValidator implements ConstraintValidator<WarehouseExists, String> {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public boolean isValid(String warehouseId, ConstraintValidatorContext constraintValidatorContext) {
        if (warehouseId == null) return true; // skip validation
        return warehouseRepository.existsById(warehouseId);
    }
}
