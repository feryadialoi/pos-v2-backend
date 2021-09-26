package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.core.BaseController;
import com.gdi.posbackend.model.criteria.SaleReturnCriteria;
import com.gdi.posbackend.model.request.CreateSaleReturnRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.DetailedSaleReturnResponse;
import com.gdi.posbackend.model.response.SaleReturnResponse;
import com.gdi.posbackend.service.SaleReturnService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 9/5/2021 2:12 AM
 */
@RestController
@RequestMapping("/api/v1/sale-returns")
@AllArgsConstructor
public class SaleReturnController extends BaseController {

    private final SaleReturnService saleReturnService;


    @GetMapping
    public ResponseEntity<ApiResponse<Page<SaleReturnResponse>>> getSaleReturns(SaleReturnCriteria saleReturnCriteria, Pageable pageable) {
        return response("get sale returns success", saleReturnService.getSaleReturns(saleReturnCriteria, pageable));
    }

    @GetMapping("/{saleReturnId}")
    public ResponseEntity<ApiResponse<DetailedSaleReturnResponse>> getSaleReturn(@PathVariable(name = "saleReturnId") String saleReturnId) {
        return response("get sale return success", saleReturnService.getSaleReturn(saleReturnId));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DetailedSaleReturnResponse>> createSaleReturn(@Valid @RequestBody CreateSaleReturnRequest createSaleReturnRequest) {
        return response("create sale return success", saleReturnService.createSaleReturn(createSaleReturnRequest));
    }

}
