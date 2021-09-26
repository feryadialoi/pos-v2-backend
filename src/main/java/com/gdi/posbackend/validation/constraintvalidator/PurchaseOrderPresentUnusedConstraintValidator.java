package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.entity.PurchaseOrder;
import com.gdi.posbackend.repository.PurchaseOrderRepository;
import com.gdi.posbackend.repository.PurchaseRepository;
import com.gdi.posbackend.validation.constraint.PurchaseOrderPresentUnused;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/18/2021 4:45 AM
 */
public class PurchaseOrderPresentUnusedConstraintValidator implements ConstraintValidator<PurchaseOrderPresentUnused, String> {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public boolean isValid(String purchaseOrderId, ConstraintValidatorContext constraintValidatorContext) {
        if (purchaseOrderId == null) return true; // skip validation

        PurchaseOrder purchaseOrder = purchaseOrderRepository.findPurchaseOrderByIdOrThrowNotFound(purchaseOrderId);
        return !purchaseRepository.existsByPurchaseOrder(purchaseOrder);
    }
}
