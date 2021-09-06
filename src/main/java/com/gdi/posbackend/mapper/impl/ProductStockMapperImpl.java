package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Product;
import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.mapper.*;
import com.gdi.posbackend.model.response.ProductOfProductStockResponse;
import com.gdi.posbackend.model.response.ProductStockResponse;
import com.gdi.posbackend.model.response.UnitResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/6/2021 3:12 PM
 */
@Component
@AllArgsConstructor
public class ProductStockMapperImpl implements ProductStockMapper {

    private final WarehouseMapper warehouseMapper;
    private final CategoryMapper categoryMapper;
    private final UnitMapper unitMapper;

    @Override
    public ProductStockResponse mapProductStockToProductStockResponse(ProductStock productStock) {
        return ProductStockResponse.builder()
                .product(mapProductToProductOfProductStockResponse(productStock.getProduct()))
                .warehouse(warehouseMapper.mapWarehouseToWarehouseResponse(productStock.getWarehouse()))
                .unit(unitMapper.mapUnitToUnitResponse(productStock.getUnit()))
                .stock(productStock.getStock())
                .build();
    }

    private ProductOfProductStockResponse mapProductToProductOfProductStockResponse(Product product) {
        return ProductOfProductStockResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .category(categoryMapper.mapCategoryToCategoryResponse(product.getCategory()))
                .build();
    }

}
