package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.criteria.SaleOrderCriteria;
import com.gdi.posbackend.model.request.CreateSaleOrderRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.DetailedSaleOrderResponse;
import com.gdi.posbackend.model.response.SaleOrderResponse;
import com.gdi.posbackend.service.SaleOrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 8/18/2021 11:49 PM
 */
@RestController
@RequestMapping("/api/v1/sale-orders")
@AllArgsConstructor
public class SaleOrderController extends BaseController {

    private final SaleOrderService saleOrderService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<SaleOrderResponse>>> getSaleOrders(SaleOrderCriteria saleOrderCriteria, Pageable pageable) {
        return response("get sale orders success", saleOrderService.getSaleOrders(saleOrderCriteria, pageable));
    }

    @GetMapping("/{saleOrderId}")
    public ResponseEntity<ApiResponse<DetailedSaleOrderResponse>> getSaleOrder(@PathVariable(name = "saleOrderId") String saleOrderId) {
        return response("get sale order success", saleOrderService.getSaleOrder(saleOrderId));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DetailedSaleOrderResponse>> createSaleOrder(@Valid @RequestBody CreateSaleOrderRequest createSaleOrderRequest) {
        return response("create sale order success", saleOrderService.createSaleOrder(createSaleOrderRequest));
    }

}
