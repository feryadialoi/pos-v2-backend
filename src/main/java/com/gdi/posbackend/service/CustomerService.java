package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.Customer;
import com.gdi.posbackend.model.criteria.CustomerCriteria;
import com.gdi.posbackend.model.request.CreateCustomerRequest;
import com.gdi.posbackend.model.request.UpdateCustomerRequest;
import com.gdi.posbackend.model.response.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:22 AM
 */
public interface CustomerService {
    Customer findCustomerByIdOrThrowNotFound(String customerId);

    Page<CustomerResponse> getCustomers(CustomerCriteria customerCriteria, Pageable pageable);

    CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest);

    CustomerResponse getCustomer(String customerId);

    CustomerResponse updateCustomer(String customerId, UpdateCustomerRequest updateCustomerRequest);

    String deleteCustomer(String customerId);

    List<CustomerResponse> getListCustomer();
}
