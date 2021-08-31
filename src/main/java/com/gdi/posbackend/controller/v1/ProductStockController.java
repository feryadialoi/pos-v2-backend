package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.criteria.ProductStockCriteria;
import com.gdi.posbackend.model.request.UpdateProductStockRequest;
import com.gdi.posbackend.model.response.ApiResponse;
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

    /**
     * Persediaan barang / stok barang
     * menampilkan semua stok barang
     * filter berdasarkan gudang / warehouse (default semua gudang)
     * pencarian berdasarkan nama / kode / nama kategori (atau nama saja?)
     * filter berdasarkan status stok -> stok kritis x stok tidak kritis
     */


    /**
     * only listing:
     * name, code, category name, stock(all), price, stock(stok minimum)
     */
    @GetMapping
    public ResponseEntity<ApiResponse<Page<Object>>> getProductStocks(ProductStockCriteria productStockCriteria, Pageable pageable) {
        return response("get product stocks success", productStockService.getProductStocks(productStockCriteria, pageable));
    }

    /**
     * listing product stock with detailed stock
     * name, code, category name, stock(all), price
     * stock/quantity per batch
     * product unit
     */
    @GetMapping("/{productStockId}")
    public ResponseEntity<ApiResponse<Object>> getProductStock(@PathVariable("productStockId") String productStockId) {
        return response("get product stock success", productStockService.getProductStock(productStockId));
    }

    @PutMapping("/{productStockId}")
    public ResponseEntity<ApiResponse<Object>> updateProductStock(@PathVariable("productStockId") String productStockId, @Valid @RequestBody UpdateProductStockRequest updateProductStockRequest) {
        return response("update product stock success", productStockService.updateProductStock(productStockId, updateProductStockRequest));
    }

    // ========================== CRUD Action =============================

}
