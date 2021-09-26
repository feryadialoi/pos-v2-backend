package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.core.BaseController;
import com.gdi.posbackend.model.criteria.PurchaseCriteria;
import com.gdi.posbackend.model.request.CreatePurchaseRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.DetailedPurchaseResponse;
import com.gdi.posbackend.model.response.PurchaseResponse;
import com.gdi.posbackend.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 8/18/2021 3:15 PM
 */
@RestController
@RequestMapping("/api/v1/purchases")
@AllArgsConstructor
public class PurchaseController extends BaseController {

    private final PurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<PurchaseResponse>>> getPurchases(PurchaseCriteria purchaseCriteria, Pageable pageable) {
        return response("get purchases success", purchaseService.getPurchases(purchaseCriteria, pageable));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DetailedPurchaseResponse>> createPurchase(@Valid @RequestBody CreatePurchaseRequest createPurchaseRequest) {
        return response("create purchase success", purchaseService.createPurchase(createPurchaseRequest));
    }

    @GetMapping("/{purchaseId}")
    public ResponseEntity<ApiResponse<DetailedPurchaseResponse>> getPurchase(@PathVariable(name = "purchaseId") String purchaseId) {
        return response("get purchase success", purchaseService.getPurchase(purchaseId));
    }

}
