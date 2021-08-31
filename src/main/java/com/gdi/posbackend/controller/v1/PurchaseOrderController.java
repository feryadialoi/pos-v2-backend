package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.criteria.PurchaseOrderCriteria;
import com.gdi.posbackend.model.request.ApprovePurchaseOrderRequest;
import com.gdi.posbackend.model.request.CreatePurchaseOrderRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.DetailedPurchaseOrderResponse;
import com.gdi.posbackend.model.response.PurchaseOrderResponse;
import com.gdi.posbackend.service.PurchaseOrderService;
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
@RequestMapping("/api/v1/purchase-orders")
@AllArgsConstructor
public class PurchaseOrderController extends BaseController {

    private final PurchaseOrderService purchaseOrderService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<PurchaseOrderResponse>>> getPurchaseOrders(PurchaseOrderCriteria purchaseOrderCriteria, Pageable pageable) {
        return response("get purchase orders success", purchaseOrderService.getPurchaseOrders(purchaseOrderCriteria, pageable));
    }

    @GetMapping("/{purchaseOrderId}")
    public ResponseEntity<ApiResponse<DetailedPurchaseOrderResponse>> getPurchaseOrders(@PathVariable(name = "purchaseOrderId") String purchaseOrderId) {
        return response("get purchase order success", purchaseOrderService.getPurchaseOrder(purchaseOrderId));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DetailedPurchaseOrderResponse>> createPurchaseOrder(@Valid @RequestBody CreatePurchaseOrderRequest createPurchaseOrderRequest) {
        return response("create purchase order success", purchaseOrderService.createPurchaseOrder(createPurchaseOrderRequest));
    }

    @PostMapping("/approve")
    public ResponseEntity<ApiResponse<Object>> approvePurchaseOrder(@Valid @RequestBody ApprovePurchaseOrderRequest approvePurchaseOrderRequest) {
        return response("purchase order approval success", purchaseOrderService.approvePurchaseOrder(approvePurchaseOrderRequest));
    }
}
