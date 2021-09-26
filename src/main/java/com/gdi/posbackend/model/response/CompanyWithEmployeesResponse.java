package com.gdi.posbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/23/2021 11:05 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyWithEmployeesResponse {
    private CompanyResponse company;
    private List<SimplifiedEmployeeResponse> employees;
}
