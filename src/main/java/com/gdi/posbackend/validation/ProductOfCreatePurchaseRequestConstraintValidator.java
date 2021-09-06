package com.gdi.posbackend.validation;

import com.gdi.posbackend.model.request.ProductOfCreatePurchaseOrderRequest;
import com.gdi.posbackend.model.request.ProductOfCreatePurchaseRequest;
import com.gdi.posbackend.validation.constraint.ProductOfCreatePurchaseOrderRequestConstraint;
import com.gdi.posbackend.validation.constraint.ProductOfCreatePurchaseRequestConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/20/2021 2:51 PM
 */
public class ProductOfCreatePurchaseRequestConstraintValidator
        implements ConstraintValidator<ProductOfCreatePurchaseRequestConstraint, List<ProductOfCreatePurchaseRequest>> {

    @Override
    public boolean isValid(List<ProductOfCreatePurchaseRequest> productOfCreatePurchaseRequests, ConstraintValidatorContext constraintValidatorContext) {

        for (ProductOfCreatePurchaseRequest productOfCreatePurchaseRequest : productOfCreatePurchaseRequests) {

            if (productOfCreatePurchaseRequest.getProductId() == null) return false;

            if (productOfCreatePurchaseRequest.getQuantity() == null) return false;

            if (productOfCreatePurchaseRequest.getPrice() == null) return false;

        }

        return true;
    }
}
