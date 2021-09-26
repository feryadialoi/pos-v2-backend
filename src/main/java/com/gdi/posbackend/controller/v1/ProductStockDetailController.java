package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.core.BaseController;
import com.gdi.posbackend.model.criteria.ProductStockDetailCriteria;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.ProductStockDetailResponse;
import com.gdi.posbackend.model.response.DetailedProductStockDetailResponse;
import com.gdi.posbackend.service.ProductStockDetailService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Feryadialoi
 * @date 9/17/2021 2:19 PM
 */
@RestController
@RequestMapping("/api/v1/product-stock-details")
@AllArgsConstructor
public class ProductStockDetailController extends BaseController {

    private final ProductStockDetailService productStockDetailService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ProductStockDetailResponse>>> getProductStockDetails(ProductStockDetailCriteria productStockDetailCriteria, Pageable pageable) {
        return response("get product stock detail success", productStockDetailService.getProductStockDetails(productStockDetailCriteria, pageable));
    }

    @GetMapping("/{productStockDetailId}/product-stock-mutations")
    public ResponseEntity<ApiResponse<DetailedProductStockDetailResponse>> getProductStockDetailWithProductStockMutations(@PathVariable(name = "productStockDetailId") String productStockDetailId) {
        return response("get product stock detail with product stock mutations success", productStockDetailService.getProductStockDetailWithProductStockMutations(productStockDetailId));
    }

}
