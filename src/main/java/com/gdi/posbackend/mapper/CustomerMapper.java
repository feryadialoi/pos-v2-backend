package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.Customer;
import com.gdi.posbackend.model.response.CustomerResponse;

/**
 * @author Feryadialoi
 * @date 9/14/2021 12:24 PM
 */
public interface CustomerMapper {

    CustomerResponse mapCustomerToCustomerResponse(Customer customer);

}
