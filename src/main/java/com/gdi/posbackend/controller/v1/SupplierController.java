package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.criteria.SupplierCriteria;
import com.gdi.posbackend.model.request.CreateSupplierRequest;
import com.gdi.posbackend.model.request.UpdateSupplierRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.SupplierResponse;
import com.gdi.posbackend.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/16/2021 9:50 AM
 */
@RestController
@RequestMapping("/api/v1/suppliers")
@AllArgsConstructor
public class SupplierController extends BaseController {

    private final SupplierService supplierService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<SupplierResponse>>> getListSupplier() {
        return response("get list supplier success", supplierService.getListSupplier());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<SupplierResponse>>> getSuppliers(SupplierCriteria supplierCriteria, Pageable pageable) {
        return response("get suppliers success", supplierService.getSuppliers(supplierCriteria, pageable));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SupplierResponse>> createSupplier(@Valid @RequestBody CreateSupplierRequest createSupplierRequest) {
        return response("create supplier success", supplierService.createSupplier(createSupplierRequest));
    }

    @PutMapping("/{supplierId}")
    public ResponseEntity<ApiResponse<SupplierResponse>> updateSupplier(@PathVariable(name = "supplierId") String supplierId, @Valid @RequestBody UpdateSupplierRequest updateSupplierRequest) {
        return response("update supplier success", supplierService.updateSupplier(supplierId, updateSupplierRequest));
    }

}
