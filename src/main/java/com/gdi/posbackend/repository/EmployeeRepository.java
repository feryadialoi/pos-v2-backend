package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Employee;
import com.gdi.posbackend.exception.EmployeeNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 9/13/2021 1:24 AM
 */
public interface EmployeeRepository extends JpaRepository<Employee, String>, JpaSpecificationExecutor<Employee> {

    default Employee findByIdOrThrowNotFound(String employeeId) {
        return findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("employee with id " + employeeId + " not found"));
    }

}
