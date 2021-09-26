package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.core.BaseController;
import com.gdi.posbackend.model.criteria.CustomerCriteria;
import com.gdi.posbackend.model.request.CreateCustomerRequest;
import com.gdi.posbackend.model.request.UpdateCustomerRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.CustomerResponse;
import com.gdi.posbackend.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/14/2021 12:13 PM
 */
@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController extends BaseController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<CustomerResponse>>> getCustomers(CustomerCriteria customerCriteria, Pageable pageable) {
        return response("get customers success", customerService.getCustomers(customerCriteria, pageable));
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<CustomerResponse>>> getListCustomer() {
        return response("get list customer success", customerService.getListCustomer());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CustomerResponse>> createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
        return response("create customer success", customerService.createCustomer(createCustomerRequest));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerResponse>> getCustomer(@PathVariable(name = "customerId") String customerId) {
        return response("get customer success", customerService.getCustomer(customerId));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerResponse>> updateCustomer(@PathVariable(name = "customerId") String customerId, @Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return response("update customer success", customerService.updateCustomer(customerId, updateCustomerRequest));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponse<String>> deleteCustomer(@PathVariable(name = "customerId") String customerId) {
        return response("delete customer success", customerService.deleteCustomer(customerId));
    }


}
