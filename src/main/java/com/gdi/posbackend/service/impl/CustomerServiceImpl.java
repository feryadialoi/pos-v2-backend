package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.Customer;
import com.gdi.posbackend.exception.CustomerDeleteNotAllowedException;
import com.gdi.posbackend.exception.CustomerNotFoundException;
import com.gdi.posbackend.mapper.CustomerMapper;
import com.gdi.posbackend.model.criteria.CustomerCriteria;
import com.gdi.posbackend.model.request.CreateCustomerRequest;
import com.gdi.posbackend.model.request.UpdateCustomerRequest;
import com.gdi.posbackend.model.response.CustomerResponse;
import com.gdi.posbackend.repository.CustomerRepository;
import com.gdi.posbackend.service.CompanyService;
import com.gdi.posbackend.service.CustomerService;
import com.gdi.posbackend.service.SaleOrderService;
import com.gdi.posbackend.service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.gdi.posbackend.specification.CustomerSpecification.*;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:22 AM
 */
@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final SaleOrderService saleOrderService;
    private final SaleService saleService;

    @Override
    public Customer findCustomerByIdOrThrowNotFound(String customerId) {
        return customerRepository
                .findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("customer with id " + customerId + " not found"));
    }

    @Override
    public Page<CustomerResponse> getCustomers(CustomerCriteria customerCriteria, Pageable pageable) {
        Specification<Customer> specification = where(null);

        if (customerCriteria.getName() != null)
            specification = specification.or(nameIsLike(customerCriteria.getName()));

        if (customerCriteria.getNationalIdentificationNumber() != null)
            specification = specification.or(nationalIdentificationNumberIsLike(customerCriteria.getNationalIdentificationNumber()));

        if (customerCriteria.getAddress() != null)
            specification = specification.or(addressIsLike(customerCriteria.getAddress()));

        if (customerCriteria.getPhone() != null)
            specification = specification.or(phoneIsLike(customerCriteria.getPhone()));

        if (customerCriteria.getPhone2() != null)
            specification = specification.or(phone2IsLike(customerCriteria.getPhone2()));

        if (customerCriteria.getDescription() != null)
            specification = specification.or(descriptionIsLike(customerCriteria.getDescription()));

        return customerRepository
                .findAll(specification, pageable)
                .map(customerMapper::mapCustomerToCustomerResponse);
    }

    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer customer = new Customer();
        customer.setName(createCustomerRequest.getName());
        customer.setNationalIdentificationNumber(createCustomerRequest.getNationalIdentificationNumber());
        customer.setAddress(createCustomerRequest.getAddress());
        customer.setPhone(createCustomerRequest.getPhone());
        customer.setPhone2(createCustomerRequest.getPhone2());
        customer.setDescription(createCustomerRequest.getDescription());

        customer = customerRepository.save(customer);

        return customerMapper.mapCustomerToCustomerResponse(customer);
    }

    @Override
    public CustomerResponse getCustomer(String customerId) {
        return customerMapper.mapCustomerToCustomerResponse(findCustomerByIdOrThrowNotFound(customerId));
    }

    @Override
    public CustomerResponse updateCustomer(String customerId, UpdateCustomerRequest updateCustomerRequest) {

        Customer customer = findCustomerByIdOrThrowNotFound(customerId);

        if (updateCustomerRequest.getName() != null)
            customer.setName(updateCustomerRequest.getName());

        if (updateCustomerRequest.getNationalIdentificationNumber() != null)
            customer.setNationalIdentificationNumber(updateCustomerRequest.getNationalIdentificationNumber());

        if (updateCustomerRequest.getAddress() != null)
            customer.setAddress(updateCustomerRequest.getAddress());

        if (updateCustomerRequest.getPhone() != null)
            customer.setPhone(updateCustomerRequest.getPhone());

        if (updateCustomerRequest.getPhone2() != null)
            customer.setPhone2(updateCustomerRequest.getPhone2());

        if (updateCustomerRequest.getDescription() != null)
            customer.setDescription(updateCustomerRequest.getDescription());


        customerRepository.save(customer);

        return customerMapper.mapCustomerToCustomerResponse(customer);
    }

    @Override
    public String deleteCustomer(String customerId) {

        Customer customer = findCustomerByIdOrThrowNotFound(customerId);

        if (saleOrderService.saleOrderCountByCustomer(customer) + saleService.saleCountByCustomer(customer) > 0) {
            throw new CustomerDeleteNotAllowedException("customer delete not allowed");
        }

        customerRepository.delete(customer);

        return customerId;
    }

    @Override
    public List<CustomerResponse> getListCustomer() {
        return customerRepository
                .findAll()
                .stream()
                .map(customerMapper::mapCustomerToCustomerResponse)
                .collect(Collectors.toList());
    }


}
