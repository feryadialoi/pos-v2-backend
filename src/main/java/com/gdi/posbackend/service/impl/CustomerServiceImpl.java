package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.Customer;
import com.gdi.posbackend.exception.CustomerNotFoundException;
import com.gdi.posbackend.repository.CustomerRepository;
import com.gdi.posbackend.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:22 AM
 */
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer findCustomerByIdOrThrowNotFound(String customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("customer with id "
                + customerId + " not found"));
    }
}
