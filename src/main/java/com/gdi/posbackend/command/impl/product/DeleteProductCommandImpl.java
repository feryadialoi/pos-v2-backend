package com.gdi.posbackend.command.impl.product;

import com.gdi.posbackend.command.product.DeleteProductCommand;
import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.exception.ProductHasStockDeleteNotAllowedException;
import com.gdi.posbackend.exception.ProductNotFoundException;
import com.gdi.posbackend.model.commandparam.DeleteProductCommandParam;
import com.gdi.posbackend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Feryadialoi
 * @date 9/10/2021 12:32 AM
 */
@Component
@Transactional
@AllArgsConstructor
public class DeleteProductCommandImpl implements DeleteProductCommand {

    private final ProductRepository productRepository;


    @Override
    public Void execute(DeleteProductCommandParam deleteProductCommandParam) {
        String  productId = deleteProductCommandParam.getProductId();
        Product product   = productRepository.findByIdOrThrowNotFound(productId);

        if (product.getProductStocks().size() > 0) {
            throw new ProductHasStockDeleteNotAllowedException("product with id " + productId + " has stock, delete not allowed");
        }

        productRepository.delete(product);

        return null;
    }

}
