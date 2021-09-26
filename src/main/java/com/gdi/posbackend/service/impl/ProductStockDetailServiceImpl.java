package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.productstockdetail.GetProductStockDetailsCommand;
import com.gdi.posbackend.command.productstockdetail.GetProductStockDetailWithProductStockMutationsCommand;
import com.gdi.posbackend.model.commandparam.GetProductStockDetailWithProductStockMutationsCommandParam;
import com.gdi.posbackend.model.commandparam.GetProductStockDetailsCommandParam;
import com.gdi.posbackend.model.criteria.ProductStockDetailCriteria;
import com.gdi.posbackend.model.response.ProductStockDetailResponse;
import com.gdi.posbackend.model.response.DetailedProductStockDetailResponse;
import com.gdi.posbackend.service.ProductStockDetailService;
import com.gdi.posbackend.service.ServiceExecutor;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 9/17/2021 2:30 PM
 */
@Service
@AllArgsConstructor
public class ProductStockDetailServiceImpl implements ProductStockDetailService {

    private final ServiceExecutor serviceExecutor;

    @Override
    public Page<ProductStockDetailResponse> getProductStockDetails(ProductStockDetailCriteria productStockDetailCriteria, Pageable pageable) {
        return serviceExecutor.execute(GetProductStockDetailsCommand.class, new GetProductStockDetailsCommandParam(productStockDetailCriteria, pageable));
    }

    @Override
    public DetailedProductStockDetailResponse getProductStockDetailWithProductStockMutations(String productStockDetailId) {
        return serviceExecutor.execute(GetProductStockDetailWithProductStockMutationsCommand.class, new GetProductStockDetailWithProductStockMutationsCommandParam(productStockDetailId));
    }

}

