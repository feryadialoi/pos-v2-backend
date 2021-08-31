package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 8/20/2021 10:32 AM
 */
public interface CompanyRepository extends JpaRepository<Company, String>, JpaSpecificationExecutor<Company> {
}
