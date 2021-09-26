package com.gdi.posbackend.command.impl.productstockdetail;

import com.gdi.posbackend.command.productstockdetail.GetProductStockDetailWithProductStockMutationsCommand;
import com.gdi.posbackend.exception.ProductStockDetailNotFoundException;
import com.gdi.posbackend.mapper.ProductStockDetailMapper;
import com.gdi.posbackend.model.commandparam.GetProductStockDetailWithProductStockMutationsCommandParam;
import com.gdi.posbackend.model.response.DetailedProductStockDetailResponse;
import com.gdi.posbackend.repository.ProductStockDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/17/2021 2:32 PM
 */
@Component
@AllArgsConstructor
public class GetProductStockDetailWithProductStockMutationsCommandImpl implements GetProductStockDetailWithProductStockMutationsCommand {

    private final ProductStockDetailRepository productStockDetailRepository;
    private final ProductStockDetailMapper productStockDetailMapper;

    @Override
    public DetailedProductStockDetailResponse execute(GetProductStockDetailWithProductStockMutationsCommandParam getProductStockDetailWithProductStockMutationsCommandParam) {
        String productStockDetailId = getProductStockDetailWithProductStockMutationsCommandParam.getProductStockDetailId();
        return productStockDetailRepository
                .findById(productStockDetailId)
                .map(productStockDetailMapper::mapProductStockDetailToDetailedProductStockDetailResponse)
                .orElseThrow(() -> new ProductStockDetailNotFoundException("product stock detail with id " + productStockDetailId + " not found"));

    }
}
