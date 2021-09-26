package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.repository.DeliveryOrderRepository;
import com.gdi.posbackend.service.DeliveryOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 9/26/2021 11:12 PM
 */
@Service
@AllArgsConstructor
public class DeliveryOrderServiceImpl implements DeliveryOrderService {

    private final DeliveryOrderRepository deliveryOrderRepository;

}
