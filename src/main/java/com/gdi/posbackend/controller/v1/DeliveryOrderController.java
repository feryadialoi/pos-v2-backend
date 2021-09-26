package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.model.criteria.DeliveryOrderCriteria;
import com.gdi.posbackend.model.request.CreateDeliveryOrderRequest;
import com.gdi.posbackend.model.request.UpdateDeliveryOrderRequest;
import com.gdi.posbackend.service.DeliveryOrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 9/26/2021 11:06 PM
 */
@RestController
@RequestMapping("/api/v1/delivery-orders")
@AllArgsConstructor
public class DeliveryOrderController {


    private final DeliveryOrderService deliveryOrderService;

    @GetMapping
    public Object getDeliveryOrders(DeliveryOrderCriteria deliveryOrderCriteria, Pageable pageable) {
        return null;
    }

    @GetMapping("/{deliveryOrderId}")
    public Object getDeliveryOrder(@PathVariable(name = "deliveryOrderId") String deliveryOrderId) {
        return null;
    }

    @PostMapping
    public Object createDeliveryOrder(@Valid @RequestBody CreateDeliveryOrderRequest createDeliveryOrderRequest) {
        return null;
    }

    @PutMapping("/{deliveryOrderId}")
    public Object updateDeliveryOrder(@PathVariable(name = "deliveryOrderId") String deliveryOrderId, @Valid @RequestBody UpdateDeliveryOrderRequest updateDeliveryOrderRequest) {
        return null;
    }

    @DeleteMapping("/{deliveryOrderId}")
    public Object deleteDeliveryOrder(@PathVariable(name = "deliveryOrderId") String deliveryOrderId) {
        return null;
    }

}
