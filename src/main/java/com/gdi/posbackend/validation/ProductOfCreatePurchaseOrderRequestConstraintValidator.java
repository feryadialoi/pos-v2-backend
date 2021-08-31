package com.gdi.posbackend.validation;

import com.gdi.posbackend.model.request.ProductOfCreatePurchaseOrderRequest;
import com.gdi.posbackend.validation.constraint.ProductOfCreatePurchaseOrderRequestConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/20/2021 2:51 PM
 */
public class ProductOfCreatePurchaseOrderRequestConstraintValidator
        implements ConstraintValidator<ProductOfCreatePurchaseOrderRequestConstraint, List<ProductOfCreatePurchaseOrderRequest>> {


    @Override
    public boolean isValid(List<ProductOfCreatePurchaseOrderRequest> productOfCreatePurchaseOrderRequests,
                           ConstraintValidatorContext constraintValidatorContext) {

        for (ProductOfCreatePurchaseOrderRequest productOfCreatePurchaseOrderRequest : productOfCreatePurchaseOrderRequests) {

            if (productOfCreatePurchaseOrderRequest.getProductId() == null) return false;

            if (productOfCreatePurchaseOrderRequest.getQuantity() == null) return false;

            if (productOfCreatePurchaseOrderRequest.getPrice() == null) return false;

        }

        return true;
    }
}
