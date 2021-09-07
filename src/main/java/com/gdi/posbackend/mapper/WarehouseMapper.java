package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseWithProductStocksResponse;
import org.springframework.data.domain.Page;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:41 AM
 */
public interface WarehouseMapper {
    DetailedWarehouseResponse mapWarehouseToDetailedWarehouseResponse(Warehouse warehouse);

    WarehouseResponse mapWarehouseToWarehouseResponse(Warehouse warehouse);

    WarehouseWithProductStocksResponse mapWarehouseToWarehouseWithProductStocksResponse(Warehouse warehouse, Page<ProductStock> productStocks);
}
