package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.entity.Purchase;
import com.gdi.posbackend.entity.Sale;
import com.gdi.posbackend.model.criteria.ProductStockCriteria;
import com.gdi.posbackend.model.request.UpdateProductStockRequest;
import com.gdi.posbackend.model.response.DetailedProductStockResponse;
import com.gdi.posbackend.model.response.ProductStockResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/6/2021 1:48 AM
 */
public interface ProductStockService {
    Page<ProductStockResponse> getProductStocks(ProductStockCriteria productStockCriteria, Pageable pageable);

    DetailedProductStockResponse getProductStock(String productStockId);

    Object updateProductStock(String productStockId, UpdateProductStockRequest updateProductStockRequest);

    void updateProductStockByPurchase(Purchase purchase);

    void updateProductStockBySale(Sale sale);

    Page<ProductStock> getProductStocksByWarehouseId(String warehouseId, Pageable pageable);

    ProductStock getProductStockByWarehouseIdAndId(String warehouseId, String productStockId);
}
