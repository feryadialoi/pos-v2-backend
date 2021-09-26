package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.ProductStockDetail;
import com.gdi.posbackend.mapper.ProductStockDetailMapper;
import com.gdi.posbackend.mapper.ProductStockMapper;
import com.gdi.posbackend.mapper.ProductStockMutationMapper;
import com.gdi.posbackend.model.response.DetailedProductStockDetailResponse;
import com.gdi.posbackend.model.response.ProductStockDetailResponse;
import com.gdi.posbackend.model.response.SimplifiedProductStockDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 9/17/2021 2:34 PM
 */
@Component
public class ProductStockDetailMapperImpl implements ProductStockDetailMapper {

    @Autowired
    private ProductStockMutationMapper productStockMutationMapper;

    @Autowired
    private ProductStockMapper productStockMapper;

    @Override
    public DetailedProductStockDetailResponse mapProductStockDetailToDetailedProductStockDetailResponse(ProductStockDetail productStockDetail) {
        return DetailedProductStockDetailResponse.builder()
                .id(productStockDetail.getId())
                .productStockMutations(productStockDetail.getProductStockMutations().stream().map(productStockMutationMapper::mapProductStockMutationToProductStockMutationResponse).collect(Collectors.toList()))
                .batch(productStockDetail.getBatch())
                .quantity(productStockDetail.getQuantity())
                .productStock(productStockMapper.mapProductStockToProductStockResponse(productStockDetail.getProductStock()))
                .build();
    }

    @Override
    public ProductStockDetailResponse mapProductStockDetailToProductStockDetailResponse(ProductStockDetail productStockDetail) {
        return ProductStockDetailResponse.builder()
                .id(productStockDetail.getId())
                .productStock(productStockMapper.mapProductStockToProductStockResponse(productStockDetail.getProductStock()))
                .quantity(productStockDetail.getQuantity())
                .batch(productStockDetail.getBatch())
                .build();
    }

    @Override
    public SimplifiedProductStockDetailResponse mapProductStockDetailToSimplifiedProductStockDetailResponse(ProductStockDetail productStockDetail) {
        return SimplifiedProductStockDetailResponse.builder()
                .id(productStockDetail.getId())
                .batch(productStockDetail.getBatch())
                .quantity(productStockDetail.getQuantity())
                .build();
    }

}
