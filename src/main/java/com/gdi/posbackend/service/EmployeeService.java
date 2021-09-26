package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.Employee;
import com.gdi.posbackend.model.criteria.EmployeeCriteria;
import com.gdi.posbackend.model.request.CreateEmployeeRequest;
import com.gdi.posbackend.model.request.UpdateEmployeeRequest;
import com.gdi.posbackend.model.response.EmployeeResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 9/13/2021 1:28 AM
 */
public interface EmployeeService {

    Page<EmployeeResponse> getEmployees(EmployeeCriteria employeeCriteria, Pageable pageable);

    EmployeeResponse getEmployee(String employeeId);

    EmployeeResponse createEmployee(CreateEmployeeRequest createEmployeeRequest);

    EmployeeResponse updateEmployee(String employeeId, UpdateEmployeeRequest updateEmployeeRequest);

    String deleteEmployee(String employeeId);

    Employee findEmployeeByIdOrThrowNotFound(String employeeId);

}
