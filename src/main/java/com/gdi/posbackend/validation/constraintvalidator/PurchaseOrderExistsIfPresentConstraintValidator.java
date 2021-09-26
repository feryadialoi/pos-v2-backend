package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.repository.PurchaseOrderRepository;
import com.gdi.posbackend.validation.constraint.PurchaseOrderExistsIfPresent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/18/2021 4:56 AM
 */
public class PurchaseOrderExistsIfPresentConstraintValidator implements ConstraintValidator<PurchaseOrderExistsIfPresent, String> {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public boolean isValid(String purchaseOrderId, ConstraintValidatorContext constraintValidatorContext) {
        if (purchaseOrderId == null) return true; // skip validation
        return purchaseOrderRepository.existsById(purchaseOrderId);
    }
}
