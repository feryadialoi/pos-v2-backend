package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.core.BaseController;
import com.gdi.posbackend.model.criteria.EmployeeCriteria;
import com.gdi.posbackend.model.request.CreateEmployeeRequest;
import com.gdi.posbackend.model.request.UpdateEmployeeRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.EmployeeResponse;
import com.gdi.posbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 9/13/2021 10:48 AM
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/employees")
@AllArgsConstructor
public class EmployeeController extends BaseController {

    private final EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<ApiResponse<Page<EmployeeResponse>>> getEmployees(EmployeeCriteria employeeCriteria, Pageable pageable) {
        log.info("get employees with criteria : {}", employeeCriteria);
        return response("get employees success", employeeService.getEmployees(employeeCriteria, pageable));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<ApiResponse<EmployeeResponse>> getEmployee(@PathVariable(name = "employeeId") String employeeId) {
        return response("get employee success", employeeService.getEmployee(employeeId));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeResponse>> createEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest) {
        return response("create employee success", employeeService.createEmployee(createEmployeeRequest));
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<ApiResponse<EmployeeResponse>> updateEmployee(@PathVariable(name = "employeeId") String employeeId, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        log.info("update employee of id : {} with request body : {}", employeeId, updateEmployeeRequest);
        return response("update employee success", employeeService.updateEmployee(employeeId, updateEmployeeRequest));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<ApiResponse<String>> deleteEmployee(@PathVariable(name = "employeeId") String employeeId) {
        return response("delete employee success", employeeService.deleteEmployee(employeeId));
    }

}
