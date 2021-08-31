package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.productstock.UpdateProductStockByPurchaseCommand;
import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.entity.enums.CogsMethod;
import com.gdi.posbackend.exception.ProductStockDetailNotFoundException;
import com.gdi.posbackend.model.commandparam.UpdateProductStockByPurchaseCommandParam;
import com.gdi.posbackend.model.criteria.ProductStockCriteria;
import com.gdi.posbackend.model.request.UpdateProductStockRequest;
import com.gdi.posbackend.repository.ProductRepository;
import com.gdi.posbackend.repository.ProductStockDetailRepository;
import com.gdi.posbackend.repository.ProductStockMutationRepository;
import com.gdi.posbackend.repository.ProductStockRepository;
import com.gdi.posbackend.service.CogsService;
import com.gdi.posbackend.service.ProductStockService;
import com.gdi.posbackend.service.RunningNumberService;
import com.gdi.posbackend.service.ServiceExecutor;
import com.gdi.posbackend.util.CompanySettingValueUtil;
import com.gdi.posbackend.util.RunningNumberCodeUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/6/2021 2:03 AM
 */
@Service
@Transactional
@AllArgsConstructor
public class ProductStockServiceImpl implements ProductStockService {

    // ** repository
    private final ProductRepository productRepository;
    private final ProductStockDetailRepository productStockDetailRepository;

    // ** service
    private final CogsService cogsService;
    private final ServiceExecutor serviceExecutor;


    @Override
    public Page<Object> getProductStocks(ProductStockCriteria productStockCriteria, Pageable pageable) {

        Product product = new Product();
        productRepository.findAll(pageable);

        return null;
    }

    @Override
    public Object getProductStock(String productStockId) {
        return null;
    }

    @Override
    public Object updateProductStock(String productStockId, UpdateProductStockRequest updateProductStockRequest) {
        return null;
    }

    @Override
    public void updateProductStockByPurchase(Purchase purchase) {
        serviceExecutor.execute(UpdateProductStockByPurchaseCommand.class, new UpdateProductStockByPurchaseCommandParam(purchase));
    }

    private ProductStockDetail findProductStockDetail(ProductStock productStock) {

        CogsMethod cogsMethod = cogsService.getCogsMethod();

        String notFoundMessage = "product stock detail with product stock of id "
                + productStock.getId()
                + " not found";

        switch (cogsMethod) {
            case FIFO:
                return productStockDetailRepository
                        .findProductStockDetailByProductStockAndQuantityGreaterThanOrderByCreatedDateAsc(productStock, BigDecimal.ZERO)
                        .orElseThrow(() -> new ProductStockDetailNotFoundException(notFoundMessage));
            case LIFO:
                return productStockDetailRepository
                        .findProductStockDetailByProductStockAndQuantityGreaterThanOrderByCreatedDateDesc(productStock, BigDecimal.ZERO)
                        .orElseThrow(() -> new ProductStockDetailNotFoundException(notFoundMessage));
            case WEIGHTED_AVERAGE:
                return productStockDetailRepository
                        .findProductStockDetailByProductStockAndQuantityGreaterThanOrderByCreatedDateAsc(productStock, BigDecimal.ZERO)
                        .orElseThrow(() -> new ProductStockDetailNotFoundException(notFoundMessage));
            default:
                throw new RuntimeException("not supported type");
        }
    }

}
