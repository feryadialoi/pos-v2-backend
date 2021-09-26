package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.SaleOrderRepository;
import com.gdi.posbackend.validation.constraint.SaleOrderExistsIfPresent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/18/2021 4:49 AM
 */
public class SaleOrderExistsIfPresentConstraintValidator implements ConstraintValidator<SaleOrderExistsIfPresent, String> {

    @Autowired
    private SaleOrderRepository saleOrderRepository;

    @Override
    public boolean isValid(String saleOrderId, ConstraintValidatorContext constraintValidatorContext) {
        if (saleOrderId == null) return true; // skip validation
        return saleOrderRepository.existsById(saleOrderId);
    }
}
