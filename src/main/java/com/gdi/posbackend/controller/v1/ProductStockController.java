package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.core.BaseController;
import com.gdi.posbackend.model.criteria.ProductStockCriteria;
import com.gdi.posbackend.model.request.UpdateProductStockRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.DetailedProductStockResponse;
import com.gdi.posbackend.model.response.ProductStockResponse;
import com.gdi.posbackend.service.ProductStockService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 8/6/2021 1:18 AM
 */
@RestController
@RequestMapping("/api/v1/product-stocks")
@AllArgsConstructor
public class ProductStockController extends BaseController {

    private final ProductStockService productStockService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ProductStockResponse>>> getProductStocks(ProductStockCriteria productStockCriteria, Pageable pageable) {
        return response("get product stocks success", productStockService.getProductStocks(productStockCriteria, pageable));
    }

    @GetMapping("/{productStockId}")
    public ResponseEntity<ApiResponse<DetailedProductStockResponse>> getProductStock(@PathVariable(name = "productStockId") String productStockId) {
        return response("get product stock success", productStockService.getProductStock(productStockId));
    }

    @PutMapping("/{productStockId}")
    public ResponseEntity<ApiResponse<Object>> updateProductStock(@PathVariable(name = "productStockId") String productStockId, @Valid @RequestBody UpdateProductStockRequest updateProductStockRequest) {
        return response("update product stock success", productStockService.updateProductStock(productStockId, updateProductStockRequest));
    }

}
