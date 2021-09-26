package com.gdi.posbackend.validation.constraintvalidator;

import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.model.request.ProductOfCreateSaleRequest;
import com.gdi.posbackend.service.ProductStockService;
import com.gdi.posbackend.validation.constraint.ProductStockSufficientForSale;
import com.gdi.posbackend.validation.constraint.ProductStockSufficientForSaleOrder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feryadialoi
 * @date 9/18/2021 5:32 AM
 */
public class ProductStockSufficientForSaleConstraintValidator implements ConstraintValidator<ProductStockSufficientForSale, ProductOfCreateSaleRequest> {

    @Autowired
    private ProductStockService productStockService;

    @Override
    public boolean isValid(ProductOfCreateSaleRequest productOfCreateSaleRequest, ConstraintValidatorContext constraintValidatorContext) {

        ProductStock productStock = productStockService.getProductStockByProductIdAndWarehouseId(
                productOfCreateSaleRequest.getProductId(),
                productOfCreateSaleRequest.getWarehouseId()
        );

        return productStock.getStock().compareTo(productOfCreateSaleRequest.getQuantity()) >= 0;

    }
}
