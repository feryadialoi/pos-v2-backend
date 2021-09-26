package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.SupplierRepository;
import com.gdi.posbackend.validation.constraint.SupplierExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/18/2021 5:59 AM
 */
public class SupplierExistsConstraintValidator implements ConstraintValidator<SupplierExists, String> {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public boolean isValid(String supplierId, ConstraintValidatorContext constraintValidatorContext) {
        if (supplierId == null) return true; // skip validation
        return supplierRepository.existsById(supplierId);
    }
}
