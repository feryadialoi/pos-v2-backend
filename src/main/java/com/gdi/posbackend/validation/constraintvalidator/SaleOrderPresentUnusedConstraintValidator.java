package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.entity.SaleOrder;
import com.gdi.posbackend.repository.SaleOrderRepository;
import com.gdi.posbackend.repository.SaleRepository;
import com.gdi.posbackend.validation.constraint.SaleOrderPresentUnused;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/18/2021 4:39 AM
 */
public class SaleOrderPresentUnusedConstraintValidator implements ConstraintValidator<SaleOrderPresentUnused, String> {

    @Autowired
    private SaleOrderRepository saleOrderRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public boolean isValid(String saleOrderId, ConstraintValidatorContext constraintValidatorContext) {
        if (saleOrderId == null) return true; // skip validation

        SaleOrder saleOrder = saleOrderRepository.findByIdOrThrowNotFound(saleOrderId);
        return !saleRepository.existsBySaleOrder(saleOrder);
    }
}
