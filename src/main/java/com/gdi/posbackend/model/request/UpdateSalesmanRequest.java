package com.gdi.posbackend.model.request;

import com.gdi.posbackend.validation.constraint.CompanyExists;
import lombok.Data;
import lombok.Value;

/**
 * @author Feryadialoi
 * @date 9/14/2021 4:25 PM
 */
@Data
public class UpdateSalesmanRequest {
    private String name;
    private String address;
    private String phone;
    private String nationalIdentificationNumber;

    @CompanyExists
    private String companyId;
}
