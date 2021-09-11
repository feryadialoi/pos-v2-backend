package com.gdi.posbackend.validation;

import com.gdi.posbackend.model.request.ProductOfCreatePurchaseRequest;
import com.gdi.posbackend.model.request.ProductOfCreateSaleOrderRequest;
import com.gdi.posbackend.validation.constraint.ProductOfCreateSaleOrderRequestConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/9/2021 1:02 PM
 */
public class ProductOfCreateSaleOrderRequestConstraintValidator implements ConstraintValidator<ProductOfCreateSaleOrderRequestConstraint, List<ProductOfCreateSaleOrderRequest>> {
    @Override
    public boolean isValid(List<ProductOfCreateSaleOrderRequest> productOfCreateSaleOrderRequests, ConstraintValidatorContext constraintValidatorContext) {

        for (ProductOfCreateSaleOrderRequest productOfCreateSaleOrderRequest : productOfCreateSaleOrderRequests) {

            if (productOfCreateSaleOrderRequest.getProductId() == null) return false;

            if (productOfCreateSaleOrderRequest.getQuantity() == null) return false;

            if (productOfCreateSaleOrderRequest.getPrice() == null) return false;

        }


        return true;
    }
}
