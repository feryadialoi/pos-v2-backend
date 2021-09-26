package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.model.request.ProductOfCreateSaleOrderRequest;
import com.gdi.posbackend.service.ProductStockService;
import com.gdi.posbackend.validation.constraint.ProductStockSufficientForSaleOrder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/18/2021 5:32 AM
 */
public class ProductStockSufficientForSaleOrderConstraintValidator implements ConstraintValidator<ProductStockSufficientForSaleOrder, ProductOfCreateSaleOrderRequest> {

    @Autowired
    private ProductStockService productStockService;

    @Override
    public boolean isValid(ProductOfCreateSaleOrderRequest productOfCreateSaleOrderRequest, ConstraintValidatorContext constraintValidatorContext) {

        ProductStock productStock = productStockService.getProductStockByProductIdAndWarehouseId(
                productOfCreateSaleOrderRequest.getProductId(),
                productOfCreateSaleOrderRequest.getWarehouseId()
        );

        return productStock.getStock().compareTo(productOfCreateSaleOrderRequest.getQuantity()) >= 0;

    }
}
