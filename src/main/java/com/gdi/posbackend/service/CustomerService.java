package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.Customer;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:22 AM
 */
public interface CustomerService {
    Customer findCustomerByIdOrThrowNotFound(String customerId);
}
