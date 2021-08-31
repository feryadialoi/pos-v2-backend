package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.Company;
import com.gdi.posbackend.model.response.CompanyResponse;

/**
 * @author Feryadialoi
 * @date 8/30/2021 10:22 AM
 */
public interface CompanyMapper {
    CompanyResponse mapCompanyToCompanyResponse(Company company);
}
