package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.criteria.WarehouseCriteria;
import com.gdi.posbackend.model.request.CreateWarehouseRequest;
import com.gdi.posbackend.model.request.UpdateWarehouseRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseWithProductStocksResponse;
import com.gdi.posbackend.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/4/2021 1:49 PM
 */
@RestController
@RequestMapping("/api/v1/warehouses")
@AllArgsConstructor
public class WarehouseController extends BaseController {

    private final WarehouseService warehouseService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<WarehouseResponse>>> getWarehouses(WarehouseCriteria warehouseCriteria, Pageable pageable) {
        return response("get warehouses success", warehouseService.getWarehouses(warehouseCriteria, pageable));
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<WarehouseResponse>>> getListWarehouse() {
        return response("get list warehouse success", warehouseService.getListWarehouse());
    }

    @GetMapping("/{warehouseId}")
    public ResponseEntity<ApiResponse<DetailedWarehouseResponse>> getWarehouse(@PathVariable(name = "warehouseId") String warehouseId) {
        return response("get warehouse success", warehouseService.getWarehouse(warehouseId));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DetailedWarehouseResponse>> createWarehouse(@Valid @RequestBody CreateWarehouseRequest createWarehouseRequest) {
        return response("create warehouse success", warehouseService.createWarehouse(createWarehouseRequest));
    }

    @PutMapping("/{warehouseId}")
    public ResponseEntity<ApiResponse<DetailedWarehouseResponse>> updateWarehouse(@PathVariable(name = "warehouseId") String warehouseId, @Valid @RequestBody UpdateWarehouseRequest updateWarehouseRequest) {
        return response("update warehouse success", warehouseService.updateWarehouse(warehouseId, updateWarehouseRequest));
    }

    @DeleteMapping("/{warehouseId}")
    public ResponseEntity<ApiResponse<Object>> deleteWarehouse(@PathVariable(name = "warehouseId") String warehouseId) {
        return response("delete warehouse success", warehouseService.deleteWarehouse(warehouseId));
    }

    @GetMapping("/{warehouseId}/product-stocks")
    public ResponseEntity<ApiResponse<WarehouseWithProductStocksResponse>> getWarehouseWithProductStocks(@PathVariable(name = "warehouseId") String warehouseId, Pageable pageable) {
        return response("get warehouse with product stocks success", warehouseService.getWarehouseWithProductStocks(warehouseId, pageable));
    }

    @GetMapping("/{warehouseId}/product-stocks/{productStockId}")
    public Object getWarehouseWithProductStock(@PathVariable(name = "warehouseId") String warehouseId, @PathVariable(name = "productStockId") String productStockId) {
        return response("get warehouse with product stock success", warehouseService.getWarehouseWithProductStock(warehouseId, productStockId));
    }

}
