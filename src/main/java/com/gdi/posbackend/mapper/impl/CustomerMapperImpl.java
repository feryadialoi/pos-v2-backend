package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Customer;
import com.gdi.posbackend.mapper.CustomerMapper;
import com.gdi.posbackend.model.response.CustomerResponse;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 9/14/2021 12:25 PM
 */
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponse mapCustomerToCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .nationalIdentificationNumber(customer.getNationalIdentificationNumber())
                .address(customer.getAddress())
                .phone(customer.getPhone())
                .phone2(customer.getPhone2())
                .description(customer.getDescription())
                .build();
    }

}
