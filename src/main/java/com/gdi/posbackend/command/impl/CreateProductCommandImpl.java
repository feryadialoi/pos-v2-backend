package com.gdi.posbackend.command.impl;

import com.gdi.posbackend.command.CreateProductCommand;
import com.gdi.posbackend.model.commandrequest.warehouse.CreateWarehouseCommandRequest;
import com.gdi.posbackend.model.response.DetailedProductResponse;
import com.gdi.posbackend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Feryadialoi
 * @date 8/13/2021 1:49 PM
 */
@Component
@Transactional
@AllArgsConstructor
public class CreateProductCommandImpl implements CreateProductCommand {

    private final ProductRepository productRepository;

    @Override
    public DetailedProductResponse execute(CreateWarehouseCommandRequest request) {




        return null;
    }
}
