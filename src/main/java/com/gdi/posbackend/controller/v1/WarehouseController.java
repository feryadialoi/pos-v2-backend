package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.criteria.WarehouseCriteria;
import com.gdi.posbackend.model.request.CreateWarehouseRequest;
import com.gdi.posbackend.model.request.UpdateWarehouseRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.DetailedWarehouseResponse;
import com.gdi.posbackend.model.response.WarehouseResponse;
import com.gdi.posbackend.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 8/4/2021 1:49 PM
 */
@RestController
@RequestMapping("/api/v1/warehouses")
@AllArgsConstructor
public class WarehouseController extends BaseController {

    private final WarehouseService warehouseService;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN','ROLE_WAREHOUSE_ADMIN','GET_WAREHOUSES')")
    @GetMapping
    public ResponseEntity<ApiResponse<Page<WarehouseResponse>, Object>> getWarehouses(WarehouseCriteria warehouseCriteria, Pageable pageable) {
        return response("get warehouses success",
                warehouseService.getWarehouses(warehouseCriteria, pageable)
        );
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN','ROLE_WAREHOUSE_ADMIN','GET_WAREHOUSE')")
    @GetMapping("/{warehouseId}")
    public ResponseEntity<ApiResponse<DetailedWarehouseResponse, Object>> getWarehouse(@PathVariable(name = "warehouseId") String warehouseId) {
        return response("get warehouse success",
                warehouseService.getWarehouse(warehouseId)
        );
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN','ROLE_WAREHOUSE_ADMIN','CREATE_WAREHOUSES')")
    @PostMapping
    public ResponseEntity<ApiResponse<DetailedWarehouseResponse, Object>> createWarehouse(@Valid @RequestBody CreateWarehouseRequest createWarehouseRequest) {
        return response("create warehouse success",
                warehouseService.createWarehouse(createWarehouseRequest)
        );
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN','ROLE_WAREHOUSE_ADMIN','UPDATE_WAREHOUSE')")
    @PutMapping("/{warehouseId}")
    public ResponseEntity<ApiResponse<DetailedWarehouseResponse, Object>> updateWarehouse(@PathVariable(name = "warehouseId") String warehouseId,
                                                                                          @Valid @RequestBody UpdateWarehouseRequest updateWarehouseRequest) {
        return response("update warehouse success",
                warehouseService.updateWarehouse(warehouseId, updateWarehouseRequest)
        );
    }

    @DeleteMapping("/{warehouseId}")
    public ResponseEntity<ApiResponse<Object, Object>> deleteWarehouse(@PathVariable(name = "warehouseId") String warehouseId) {
        return response("delete warehouse success",
                warehouseService.deleteWarehouse(warehouseId)
        );
    }

}
