package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.core.BaseController;
import com.gdi.posbackend.model.criteria.PurchaseReturnCriteria;
import com.gdi.posbackend.model.request.CreatePurchaseReturnRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.DetailedPurchaseReturnResponse;
import com.gdi.posbackend.model.response.PurchaseReturnResponse;
import com.gdi.posbackend.service.PurchaseReturnService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 9/5/2021 2:03 AM
 */
@RestController
@RequestMapping("/api/v1/purchase-returns")
@AllArgsConstructor
public class PurchaseReturnController extends BaseController {

    private final PurchaseReturnService purchaseReturnService;


    @GetMapping
    public ResponseEntity<ApiResponse<Page<PurchaseReturnResponse>>> getPurchaseReturns(PurchaseReturnCriteria purchaseReturnCriteria, Pageable pageable) {
        return response("get purchase returns success", purchaseReturnService.getPurchaseReturns(purchaseReturnCriteria, pageable));
    }

    @GetMapping("/{purchaseReturnId}")
    public ResponseEntity<ApiResponse<DetailedPurchaseReturnResponse>> getPurchaseReturn(@PathVariable(name = "purchaseReturnId") String purchaseReturnId) {
        return response("get purchase return success", purchaseReturnService.getPurchaseReturn(purchaseReturnId));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DetailedPurchaseReturnResponse>> createPurchaseReturn(@Valid @RequestBody CreatePurchaseReturnRequest createPurchaseReturnRequest) {
        return response("create purchase return success", purchaseReturnService.createPurchaseReturn(createPurchaseReturnRequest));
    }


}
