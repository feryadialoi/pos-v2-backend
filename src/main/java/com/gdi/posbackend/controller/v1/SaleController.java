package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.core.BaseController;
import com.gdi.posbackend.entity.enums.Authority;
import com.gdi.posbackend.model.criteria.SaleCriteria;
import com.gdi.posbackend.model.request.CreateSaleRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.DetailedSaleResponse;
import com.gdi.posbackend.model.response.SaleResponse;
import com.gdi.posbackend.service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 8/18/2021 11:42 PM
 */
@RestController
@RequestMapping("/api/v1/sales")
@AllArgsConstructor
public class SaleController extends BaseController {

    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<SaleResponse>>> getSales(SaleCriteria saleCriteria, Pageable pageable) {
        return response("get sales success", saleService.getSales(saleCriteria, pageable));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN','CREATE_SALE')")
    @PostMapping
    public ResponseEntity<ApiResponse<DetailedSaleResponse>> createSale(@Valid @RequestBody CreateSaleRequest createSaleRequest) {
        return response("create sale success", saleService.createSale(createSaleRequest));
    }

    @GetMapping("/{saleId}")
    public ResponseEntity<ApiResponse<DetailedSaleResponse>> getSale(@PathVariable(name = "saleId") String saleId) {
        return response("get sale success", saleService.getSale(saleId));
    }
}
