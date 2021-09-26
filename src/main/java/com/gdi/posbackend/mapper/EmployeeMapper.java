package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.Employee;
import com.gdi.posbackend.model.response.EmployeeResponse;
import com.gdi.posbackend.model.response.SimplifiedEmployeeResponse;

/**
 * @author Feryadialoi
 * @date 9/13/2021 2:28 AM
 */
public interface EmployeeMapper {
    EmployeeResponse mapEmployeeToEmployeeResponse(Employee employee);

    SimplifiedEmployeeResponse mapEmployeeToSimplifiedEmployeeResponse(Employee employee);
}
